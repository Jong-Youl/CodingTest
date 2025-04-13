import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int [2];

        int cnt = 1;
        char prev = words[0].charAt(words[0].length() - 1);
        boolean isPossible = true;
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        while(cnt < words.length) {
            String curr = words[cnt];

            if (curr.length() <= 1 || prev != curr.charAt(0) || set.contains(curr)) {
                answer[0] = (cnt % n) + 1;
                answer[1] = (cnt / n) + 1;
                isPossible = false;
                break;
            }

            set.add(curr);
            prev = curr.charAt(curr.length() - 1);
            cnt++;
        }

        if(isPossible) {
            answer[0] = 0;
            answer[1] = 0;   
        }
        
        return answer;
    }
}