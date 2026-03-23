import java.util.*;
import java.io.*;

public class Main {
	static int N, Hatk;
	static int[][] tah;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Hatk = Integer.parseInt(st.nextToken());

		tah = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()); // type 1은 몬스터, 2는 포션
			int a = Integer.parseInt(st.nextToken()); // 공격력, 증가 공격력
			int h = Integer.parseInt(st.nextToken()); // 생명력, 증가 생명력
			tah[i] = new int[] { t, a, h };
		}

		long lo = 0;
		long hi = Long.MAX_VALUE;
		while (lo + 1 < hi) {
			long mid = (lo + hi) / 2;
			if (check(mid)) {
				hi = mid;
			} else {
				lo = mid;
			}
		}

		System.out.println(hi);
	}

	public static boolean check(long mid) {
		long Hmax = mid;
		long Hcur = mid;
		long atk = Hatk;
		for (int i = 0; i < N; i++) {
			if (tah[i][0] == 1) { // 몬스터!!
				long monsterHp = tah[i][2];
				long monsterAtk = tah[i][1];

				long attackCount = (monsterHp + atk - 1) / atk;
				long damageCount = attackCount - 1;
				Hcur -= damageCount * monsterAtk;
				if (Hcur <= 0)
					return false;
			} else { // 포션!!
				Hcur = Math.min(Hcur + tah[i][2], Hmax);
				atk += tah[i][1];
			}
		}
		return true;
	}
}
