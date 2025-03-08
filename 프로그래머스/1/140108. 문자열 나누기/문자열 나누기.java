import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int tCnt = 0;
        int fCnt = 0;
        char target = s.charAt(0);
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if(target == curr)
                tCnt++;
            else
                fCnt++;
            
            if(tCnt == fCnt) {
                answer++;
                if(i < s.length() - 1)
                    target = s.charAt(i + 1);
                tCnt = 0;
                fCnt = 0;
            }
        }
        
        if(tCnt != fCnt)
            answer++;
        
        return answer;
    }
}