import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        List<Integer> trit = new ArrayList<>();
        while(n != 0){
            trit.add(n % 3);
            n /= 3;
        }
        
        int mul = 1;
        for(int i = trit.size()-1; i >= 0; i--){
            int num = trit.get(i);
            answer += num * mul;
            mul *= 3;
        }
        
        
        return answer;
    }
}