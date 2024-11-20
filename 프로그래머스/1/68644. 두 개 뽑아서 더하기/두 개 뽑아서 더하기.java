import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length; j++){
                if(i == j || result.contains(numbers[i] + numbers[j])){
                    continue;
                }
                result.add(numbers[i] + numbers[j]);
            }
        }
        
        Collections.sort(result);
        
        int[] answer = result.stream()
                .mapToInt(i -> i)
                .toArray();
        
        
        return answer;
    }
}