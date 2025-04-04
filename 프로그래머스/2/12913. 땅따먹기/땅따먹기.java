class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        
        int[][] dp = new int[n][4];
        for (int i = 0; i < 4; i++)
            dp[0][i] = land[0][i];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                int maxPrev = 0;
                
                for (int k = 0; k < 4; k++) {
                    if (k != j)
                        maxPrev = Math.max(maxPrev, dp[i - 1][k]);
                }
                dp[i][j] = land[i][j] + maxPrev;
            }
        }
        
        for (int j = 0; j < 4; j++)
            answer = Math.max(answer, dp[n - 1][j]);
        
        return answer;
    }
}