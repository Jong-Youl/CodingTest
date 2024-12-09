import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;
        for (int[] p : problems) {
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }

        // 초기 상태
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);

        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[alp][cop] = 0;

        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                // 1. 알고리즘 공부
                if (i + 1 <= maxAlp) dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                
                // 2. 코딩 공부
                if (j + 1 <= maxCop) dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                
                // 3. 문제 풀이
                for (int[] p : problems) {
                    if (i >= p[0] && j >= p[1]) {
                        int nextAlp = Math.min(maxAlp, i + p[2]);
                        int nextCop = Math.min(maxCop, j + p[3]);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + p[4]);
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}
