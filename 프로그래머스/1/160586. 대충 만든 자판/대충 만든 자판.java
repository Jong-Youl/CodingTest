import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int size = targets.length;
        int[] answer = new int [size];
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (String str : keymap) {
            for (int i = 0; i < str.length(); i++) {
                map.put(str.charAt(i), Math.min(map.getOrDefault(str.charAt(i), i + 1), i + 1));
            }
        }
        
        for(int i = 0; i < size; i++) {
            String target = targets[i];
            int sum = 0;
            
            for(int j = 0; j < target.length(); j++) {
                char curr = target.charAt(j);
                if(!map.containsKey(curr)) {
                    sum = -1;
                    break;
                }
                sum += map.get(curr);
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}