import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Deque<int[]> dq = new ArrayDeque<>();
        
        for(int i = 0 ; i < priorities.length; i++) {
            pq.offer(priorities[i]);
            dq.offer(new int[] {i, priorities[i]});
        }
        
        int cnt = 0;
        while(true) {
            cnt++;
            int first = pq.poll();
            int[] process = dq.poll();
            
            if(first > process[1]) {
                while(first != process[1]) {
                    dq.offer(process);
                    process = dq.poll();
                }
            }
            
            if(process[0] == location) {
                break;
            }
        }
        
        return cnt;
    }
}




