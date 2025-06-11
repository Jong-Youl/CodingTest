import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        
        // 50 * 100 * 100 -> 50만
        int [] temp;
        int st, ed, k;
        int idx = 0;
        for(int [] command : commands) {
            st = command[0] - 1;
            ed = command[1] - 1;
            k = command[2] - 1;
            temp = new int [ed - st + 1];
            
            for(int i = st; i <= ed; i++) 
                temp[i - st] = array[i];
            
            Arrays.sort(temp);
            answer[idx++] = temp[k];
        }
        
        
        return answer;
    }
}