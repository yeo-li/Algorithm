import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        
        int gcd = GCD(n ,m);
        int lcm = n*m/gcd;
        
        int[] answer = {gcd, lcm};
        
        
        return answer;
    }
    
    private int GCD(int a, int b){
        if(a%b == 0){
            return b;
        }
        
        return GCD(b, a%b);
    }
}