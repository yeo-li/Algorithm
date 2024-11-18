import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isValid(c)){
                if(isUpper(c)){
                    c = (char)((((int)c + n - (int)'A'))%26 + (int)'A');
                } else if(isLowwer(c)){
                    c = (char)((((int)c + n - (int)'a'))%26 + (int)'a');
                }
            }
            answer += Character.toString(c);
        }
        
        return answer;
    }
    
    private boolean isValid(char c){
        return ('A' <= c && c <='Z') || ('a' <= c && c <='z');
    }
    
    private boolean isUpper(char c){
        return ('A' <= c && c <='Z');
    }
    
    private boolean isLowwer(char c){
        return ('a' <= c && c <='z');
    }
}