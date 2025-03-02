import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int [s.length()];
        
        // alph, idx
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(!map.containsKey(curr)) {
                answer[i] = -1;
            }
            else {
                answer[i] = i - map.get(curr);
            }
            map.put(curr, i);
        }
        return answer;
    }
}