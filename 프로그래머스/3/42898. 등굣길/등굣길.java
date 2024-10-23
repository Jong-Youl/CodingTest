class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;
        
        int [][] dp = new int [n][m];
        
        dp[0][0] = 1;
        
        // 웅덩이 처리
        for(int [] puddle : puddles)
            dp[puddle[1] - 1][puddle[0] - 1] = -1;    
        
        for(int r = 1; r < n; r++) {
            if(dp[r][0] == -1) dp[r][0] = 0;
            else dp[r][0] = dp[r-1][0];
        }
            
        for(int c = 1; c < m; c++) {
            if(dp[0][c] == -1) dp[0][c] = 0;
            else dp[0][c] = dp[0][c-1];
        }
        
        for(int r = 1; r < n; r++) {
            for(int c = 1; c < m; c++) {
                if(dp[r][c] == -1) dp[r][c] = 0;
                else
                    dp[r][c] = (dp[r - 1][c] + dp[r][c - 1]) % mod;
            }
        }
        
        return dp[n-1][m-1];
    }
}