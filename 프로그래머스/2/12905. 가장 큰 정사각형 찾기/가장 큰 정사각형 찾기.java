class Solution {
    public int solution(int [][]board) {
        int height = board.length;
        int width = board[0].length;
        int maxSize = 0;

        int[][] dp = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 1) {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1; 
                    
                    else
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }

        return maxSize * maxSize;
    }
}
