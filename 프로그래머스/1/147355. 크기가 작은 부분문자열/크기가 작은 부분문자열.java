import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        Long np = Long.parseLong(p);
        for(int i = 0; i <= t.length() - p.length(); i++) {
            String q = t.substring(i, i + p.length());
            Long nq = Long.parseLong(q);
            
            if(np >= nq){
                answer++;
            }
        }
        
        return answer;
    }
}