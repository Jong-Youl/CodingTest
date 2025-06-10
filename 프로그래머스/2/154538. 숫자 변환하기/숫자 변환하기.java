class Solution {
    public int solution(int x, int y, int n) {
        int [] dp = new int [1_000_001];
        
        if(x == y) 
            return 0;
        if(x + n <= 1000000)
            dp[x + n] = 1;
        if(x * 2 <= 1000000)
            dp[x * 2] = 1;
        if(x * 3 <= 1000000)
            dp[x * 3] = 1;
        
        if(x == y) 
            return 0;
        
        for(int i = x; i < y; i++) {
            if(dp[i] == 0)
                continue;
            
            if(i + n <= 1000000) {
                if(dp[i + n] == 0)
                    dp[i + n] = dp[i] + 1;
                else
                    dp[i + n] = Math.min(dp[i + n], dp[i] + 1);                
            }

            if(i * 2 <= 1000000) {
                if(dp[i * 2] == 0)
                    dp[i * 2] = dp[i] + 1;
                else
                    dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);                
            }

            if(i * 3 <= 1000000) {
                if(dp[i * 3] == 0)
                    dp[i * 3] = dp[i] + 1;
                else
                    dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);                
            }
        }
                
        return dp[y]==0?-1:dp[y];
    }
}