import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    static class Arc {
        int id;
        int u, v;
        int low;
        long base;
        long mul;
        long num, den;
    }

    static int n; // number of dimensions
    static long[] w;
    static long[] cp;

    static Arc[] h;
    static int nArcs;

    static int[] sub;
    static ArrayList<Integer>[] child;

    static int nPqs;
    static int[] qid;
    static PriorityQueue<Integer>[] pq;

    static ArrayList<Integer>[] con;

    static long support(int arcId) {
        Arc a = h[arcId];
        return a.num / a.den;
    }

    static boolean contains(Arc a, Arc b) {
        return a.u <= b.u && b.v <= a.v;
    }

    static void newArc(int u, int v) {
        ++nArcs;
        Arc a = h[nArcs];
        a.id = nArcs;
        a.u = u;
        a.v = v;
        a.low = (w[u] < w[v]) ? u : v;
        a.mul = w[u] * w[v];
        a.base = cp[v] - cp[u] - a.mul;
        a.num = 0;
        a.den = 0;
    }

    static void buildTree(ArrayList<int[]> lst) {
        ArrayList<Integer> stk = new ArrayList<>();

        newArc(1, n + 1); // root = h[1]

        for (int[] it : lst) {
            newArc(it[0], it[1]);
            while (!stk.isEmpty() && contains(h[nArcs], h[stk.get(stk.size() - 1)])) {
                child[nArcs].add(stk.remove(stk.size() - 1));
            }
            stk.add(nArcs);
        }

        while (!stk.isEmpty()) {
            child[1].add(stk.remove(stk.size() - 1));
        }
    }

    static void oneSweep() {
        ArrayList<Integer> stk = new ArrayList<>();
        ArrayList<int[]> tmp = new ArrayList<>();
        ArrayList<int[]> lst = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            while (stk.size() >= 2 && w[stk.get(stk.size() - 1)] > w[i]) {
                tmp.add(new int[]{stk.get(stk.size() - 2), i});
                stk.remove(stk.size() - 1);
            }
            stk.add(i);
        }

        while (stk.size() >= 4) {
            int vt1 = stk.get(stk.size() - 2);
            tmp.add(new int[]{1, vt1});
            stk.remove(stk.size() - 1);
        }

        for (int[] it : tmp) {
            if (it[0] == 1 || it[1] == 1) continue;
            lst.add(it);
        }

        buildTree(lst);
    }

    static void prepare(long[] arr) {
        int minIdx = 1;
        for (int i = 2; i <= n; i++) {
            if (w[i] < w[minIdx]) minIdx = i;
        }

        long[] orig = new long[n + 1];
        System.arraycopy(w, 1, orig, 1, n);

        int idx = 1;
        for (int i = minIdx; i <= n; i++) w[idx++] = orig[i];
        for (int i = 1; i < minIdx; i++) w[idx++] = orig[i];

        w[n + 1] = w[1];

        for (int i = 1; i <= n + 1; i++) {
            cp[i] = w[i] * w[i - 1];
            cp[i] += cp[i - 1];
        }
    }

    static long getMnMul(int node) {
        if (node == 1) return w[1] * w[2] + w[1] * w[n];

        Arc cur = h[node];
        if (cur.u == cur.low) {
            if (con[cur.u].isEmpty() || !contains(cur, h[con[cur.u].get(con[cur.u].size() - 1)])) {
                return w[cur.u] * w[cur.u + 1];
            } else {
                return h[con[cur.u].get(con[cur.u].size() - 1)].mul;
            }
        } else {
            if (con[cur.v].isEmpty() || !contains(cur, h[con[cur.v].get(con[cur.v].size() - 1)])) {
                return w[cur.v] * w[cur.v - 1];
            } else {
                return h[con[cur.v].get(con[cur.v].size() - 1)].mul;
            }
        }
    }

    static void addArc(int curNode, Arc arc) {
        pq[qid[curNode]].add(arc.id);
        con[arc.u].add(arc.id);
        con[arc.v].add(arc.id);
    }

    static void removeArc(int curNode) {
        int hmId = pq[qid[curNode]].peek();
        Arc hm = h[hmId];
        con[hm.u].remove(con[hm.u].size() - 1);
        con[hm.v].remove(con[hm.v].size() - 1);
        pq[qid[curNode]].poll();
    }

    static void mergePq(int node) {
        int maxChild = -1;
        for (int it : child[node]) {
            if (maxChild == -1 || sub[maxChild] < sub[it]) maxChild = it;
        }

        qid[node] = qid[maxChild];
        PriorityQueue<Integer> curPq = pq[qid[node]];

        for (int it : child[node]) {
            if (it == maxChild) continue;
            PriorityQueue<Integer> childPq = pq[qid[it]];
            while (!childPq.isEmpty()) {
                curPq.add(childPq.poll());
            }
        }
    }

    static void dfs(int node) {
        Arc cur = h[node];
        sub[node] = 1;

        if (child[node].isEmpty()) {
            qid[node] = ++nPqs;
            cur.den = cur.base;
            cur.num = w[cur.low] * (cur.den + cur.mul - getMnMul(node));
            addArc(node, cur);
            return;
        }

        cur.den = cur.base;
        for (int it : child[node]) {
            dfs(it);
            sub[node] += sub[it];
            cur.den -= h[it].base;
        }

        cur.num = w[cur.low] * (cur.den + cur.mul - getMnMul(node));
        mergePq(node);

        PriorityQueue<Integer> curPq = pq[qid[node]];

        while (!curPq.isEmpty() && support(curPq.peek()) >= w[cur.low]) {
            int hmId = curPq.peek();
            Arc hm = h[hmId];
            cur.den += hm.den;
            removeArc(node);
            cur.num = w[cur.low] * (cur.den + cur.mul - getMnMul(node));
        }

        while (!curPq.isEmpty() && support(cur.id) <= support(curPq.peek())) {
            int hmId = curPq.peek();
            Arc hm = h[hmId];
            cur.den += hm.den;
            removeArc(node);
            cur.num += hm.num;
        }

        addArc(node, cur);
    }

    static long getAnswer() {
        dfs(1);
        long ans = 0;
        PriorityQueue<Integer> rootPq = pq[qid[1]];
        while (!rootPq.isEmpty()) {
            ans += h[rootPq.poll()].num;
        }
        return ans;
    }

    static long solve(long[] dims) {
        int matrixCount = dims.length - 1;
        if (matrixCount <= 1) return 0L;
        if (matrixCount == 2) return dims[0] * dims[1] * dims[2];

        n = dims.length;

        w = new long[n + 2];
        cp = new long[n + 2];

        int maxSize = n + 5;
        h = new Arc[maxSize * 2];
        for (int i = 0; i < h.length; i++) h[i] = new Arc();

        sub = new int[maxSize * 2];
        qid = new int[maxSize * 2];

        child = new ArrayList[maxSize * 2];
        for (int i = 0; i < child.length; i++) child[i] = new ArrayList<>();

        con = new ArrayList[maxSize * 2];
        for (int i = 0; i < con.length; i++) con[i] = new ArrayList<>();

        pq = new PriorityQueue[maxSize * 2];
        Comparator<Integer> cmp = (a, b) -> {
            long sa = support(a);
            long sb = support(b);
            return Long.compare(sb, sa); // max-heap by support
        };
        for (int i = 0; i < pq.length; i++) pq[i] = new PriorityQueue<>(cmp);

        nArcs = 0;
        nPqs = 0;

        for (int i = 1; i <= n; i++) w[i] = dims[i - 1];

        prepare(dims);
        oneSweep();
        return getAnswer();
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();

        long[] dims = new long[N + 1];
        long prevC = -1;

        for (int i = 0; i < N; i++) {
            long r = fs.nextLong();
            long c = fs.nextLong();
            if (i == 0) dims[0] = r;
            dims[i + 1] = c;
            prevC = c;
        }

        System.out.println(solve(dims));
    }
}