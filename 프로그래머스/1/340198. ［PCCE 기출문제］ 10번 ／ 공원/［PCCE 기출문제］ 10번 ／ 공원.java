import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        //mats => 돗자리, park -> 지역 정보
        
        Arrays.sort(mats);
        // 제일 큰 것부터 
        for(int idx = mats.length - 1; idx >= 0; idx--) {
            if(isPossible(park, mats[idx])) {
                answer = mats[idx];
                break;
            }
        }
        
        return answer;
    }
    
    
    public boolean isPossible(String [][] park, int size) {
        for(int r = 0; r < park.length; r++) {
         p: for(int c = 0; c < park[r].length; c++) {
                // size * size 탐색
                for(int i = 0; i < size; i++) {
                    for(int j = 0; j < size; j++) {
                        if(r + i >= park.length || c + j >= park[r].length || !park[r + i][c + j].equals("-1")) {
                            continue p;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}