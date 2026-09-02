import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        Arrays.sort(phone_book, (o1, o2) -> o1.length() - o2.length());
        
        for(String pn : phone_book) {
            for(int i = phone_book[0].length(); i <= pn.length(); i++) {
                String pnsub = pn.substring(0, i);
                if(set.contains(pnsub)) return false;
            }
            set.add(pn);
        }

        return true;
    }
}