import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        List<String> pList = Arrays.asList("aya", "ye", "woo", "ma");
        List<String> impList = Arrays.asList("ayaaya", "yeye", "woowoo", "mama");

        for (String curr : babbling) {
            boolean isValid = true;
            for (String imp : impList) {
                if (curr.contains(imp)) {
                    isValid = false;
                    break;
                }
            }
            if (!isValid) continue;

            String temp = curr;
            for (String word : pList) {
                temp = temp.replace(word, " ");
            }
            
            if (temp.trim().isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}
