import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(getRemoveRocks(rocks, mid, distance) <= n) {
                answer = mid;
                left = mid + 1;   
            }
            else
                right = mid - 1;
        }
        
        
        return answer;
    }
    
    public int getRemoveRocks(int [] rocks, int mid, int distance) {
        int start = 0;
        int end = distance;
        
        int removeCnt = 0;
        
        for(int i = 0; i < rocks.length; i++) {
            int diff = rocks[i] - start;
            
            if(diff < mid)
                removeCnt++;
            else 
                start = rocks[i];
        }
        
        if(end - start < mid) removeCnt++;
        
        return removeCnt;
    }
}