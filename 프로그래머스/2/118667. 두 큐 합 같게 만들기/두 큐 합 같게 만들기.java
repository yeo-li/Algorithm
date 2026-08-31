import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int num : queue1) {
            sum1 += num;
            q1.offer(num);
        }
        for(int num : queue2) {
            sum2 += num;
            q2.offer(num);
        }
        
        long aim = (sum1 + sum2)%2 == 0 ? (sum1 + sum2) / 2 : -1;
        if(aim == -1) return -1;
        
        int maxOperations = queue1.length * 4;

        
        while(sum1 != sum2) {
            if(answer >= maxOperations) return -1;
            
            if(sum1 > sum2) {
                int a = q1.poll();
                q2.offer(a);
                sum1 -= a;
                sum2 += a;
            } else if(sum1 < sum2) {
                int a = q2.poll();
                q1.offer(a);
                sum2 -= a;
                sum1 += a;
            }
            
            answer++;
        }
        
        return answer;
    }
}