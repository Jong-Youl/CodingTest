import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        int reps = 1;
        while(reps <= elements.length) {
            // i부터 reps개 챙기기
            for(int i = 0; i < elements.length; i++) {
                int curr = 0;
                for(int j = 0; j < reps; j++)
                    curr += elements[(i + j) % elements.length];
                set.add(curr);
            }
            reps++;
        }
        
        answer = set.size();
        return answer;
    }
}