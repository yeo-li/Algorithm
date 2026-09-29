import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] chars = s.toCharArray();
        
        Deque<Character> dq = new ArrayDeque<>();
        
        for(char c : chars) {
            if(c == '(') dq.push(c);
            else {
                if(dq.peekLast() == null || dq.peekLast() != '(') {
                    answer = false;
                    break;  
                }
                dq.pop();
                continue;
            }
        }
        
        if(!dq.isEmpty()) answer = false;
        
        return answer;
    }
}