import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int [k];
        boolean [] check = new boolean [100_001];
        Arrays.fill(answer, -1);
        
        int tmp = -1;
        int idx = 0;
        
        for(int num : arr) {
            if(num != tmp && !check[num]){
                tmp = num;
                check[num] = true;
                answer[idx++] = tmp;
            }
            if(idx == k) break;
        }
        
        return answer;
    }
}