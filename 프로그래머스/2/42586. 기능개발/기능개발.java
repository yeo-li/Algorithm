import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        int[] diff = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            diff[i] = (100 - progresses[i]) / speeds[i];
            diff[i] += (100 - progresses[i]) % speeds[i] == 0? 0 : 1;
        }
        
        List<Integer> ans = new ArrayList<>();
        int cnt = 1;
        int number = diff[0];
        boolean isEnd = true;
        for(int i = 1; i < progresses.length; i++) {
            if(number >= diff[i]) {
                cnt++;
                isEnd = false;
            } else {
                ans.add(cnt);
                cnt = 1;
                number = diff[i];
                isEnd = true;
            }
        }
        
        ans.add(cnt);
        
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
}