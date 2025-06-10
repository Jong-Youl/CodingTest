class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] dp = new int[n][m];
        
        // 웅덩이 처리
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        // 출발점이 웅덩이면 0 반환
        if (dp[0][0] == -1) return 0;
        
        dp[0][0] = 1;
        
        // 첫 번째 행 초기화 (웅덩이를 만나면 이후는 0)
        for (int c = 1; c < m; c++) {
            if (dp[0][c] == -1) {
                dp[0][c] = 0;
            } else {
                dp[0][c] = dp[0][c - 1];
            }
        }
        
        // 첫 번째 열 초기화 (웅덩이를 만나면 이후는 0)
        for (int r = 1; r < n; r++) {
            if (dp[r][0] == -1) {
                dp[r][0] = 0;
            } else {
                dp[r][0] = dp[r - 1][0];
            }
        }
        
        // 나머지 dp 테이블 채우기
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                if (dp[r][c] == -1) {
                    dp[r][c] = 0;  // 웅덩이는 지나갈 수 없으므로 0으로 설정
                } else {
                    dp[r][c] = (dp[r - 1][c] + dp[r][c - 1]) % MOD;
                }
            }
        }
        
        return dp[n - 1][m - 1];
    }
}
