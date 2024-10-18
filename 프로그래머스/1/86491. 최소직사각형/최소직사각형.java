import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        for(int i = 0; i < sizes.length; i++){    
            if(sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        
        int maxW = 0;
        int maxH = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            maxH = Math.max(maxH, sizes[i][0]);            
            maxW = Math.max(maxW, sizes[i][1]);
        }
        
        return maxH * maxW;
    }   
}