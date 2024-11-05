import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[arr.length-1]);
        for(int i = arr.length-2; i >= 0 ; i--) {
            Integer elem = stack.pop();
            if(elem != arr[i]){
                stack.push(elem);
            }
            stack.push(arr[i]);
        }
        
        int[] answer = new int[stack.size()];
        int idx = 0;
        while(!stack.isEmpty()) {
            answer[idx] = stack.pop();
            idx++;
        }
        
        
        
        return answer;
    }
}