class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;
        int weight = triangle[height - 1].length;
        int [][] dp = new int [height][weight];
        
        for(int i = 0; i < triangle[height - 1].length; i++)
            dp[height - 1][i] = triangle[height - 1][i];
            
        for(int i = height - 1; i >= 1; i--) {
            for(int j = 0; j < triangle[i].length - 1; j++) {
                int curr = Math.max(dp[i][j], dp[i][j + 1]);
                
                dp[i - 1][j] += curr + triangle[i - 1][j];
            }
        }

        return dp[0][0];
    }
}