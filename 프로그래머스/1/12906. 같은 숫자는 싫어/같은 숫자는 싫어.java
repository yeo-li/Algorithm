import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int num : arr) {
            if(!dq.isEmpty() && dq.peek() == num) 
                continue;
            
            dq.push(num);
        }
        
        int[] ans = new int[dq.size()];
        for(int i = ans.length - 1; i >= 0 ; i--) {
            ans[i] = dq.pop();
        }
        
        return ans;
    }
}