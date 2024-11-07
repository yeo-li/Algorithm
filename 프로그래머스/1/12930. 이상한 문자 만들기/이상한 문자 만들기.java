import java.util.*;

class Solution {
    public String solution(String s) {
       		 String answer = "";
	        
	        s = s.toUpperCase() + "a";
	        String[] parsedString = s.split(" ");
	        
	        for(String word: parsedString) {
	            for(int i = 0; i < word.length(); i++) {
	                String c = String.valueOf(word.charAt(i));
	                
	                if(i%2 != 0){ // 홀수라면
	                    c = c.toLowerCase();
	                }
	                answer += c;
	            }
	            answer += " ";
	        }
	        
	       
	        return answer.substring(0,answer.length() - 2);
    }
}