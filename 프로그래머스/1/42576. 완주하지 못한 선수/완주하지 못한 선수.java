import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String ans = "";
        
        Map<String, Integer> p = new HashMap<>();
        Map<String, Integer> c = new HashMap<>();
        for(String name : participant) {
            p.put(name, p.getOrDefault(name, 0) + 1);
        }
        
        for(String name : completion) {
            c.put(name, c.getOrDefault(name, 0) + 1);
        }
        
        for(String name : participant) {
            int pNum = p.getOrDefault(name, 0);
            int cNum = c.getOrDefault(name, 0);
            
            if(pNum != cNum) {
                ans = name;
                return ans;
            }
        }
        
        
        return ans;
    }
}