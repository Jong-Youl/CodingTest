import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        // 각 위치마다 필요한 건전지값의 최소량
        
        while(n > 0) {
            if(n % 2 == 0)
                n /= 2;
            else {
                n -= 1;
                ans++;
            }
        }
        return ans;
    }
}