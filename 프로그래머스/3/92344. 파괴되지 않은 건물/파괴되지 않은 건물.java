class Solution {
    public int solution(int[][] board, final int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;

        int[][] prefixSum = calculatePrefixSum(N, M, skill);

        applyPrefixSum(board, prefixSum);
        answer = getValidCnt(board);
        
        return answer;
    }

    private int[][] calculatePrefixSum(int N, int M, int[][] skill) {
        int[][] prefixSum = new int[N + 1][M + 1];

        for (int[] sInfo : skill) {
            int type = sInfo[0];
            int r1 = sInfo[1], c1 = sInfo[2], r2 = sInfo[3], c2 = sInfo[4];
            int degree = (type == 1) ? -sInfo[5] : sInfo[5];

            prefixSum[r1][c1] += degree;
            prefixSum[r1][c2 + 1] -= degree;
            prefixSum[r2 + 1][c1] -= degree;
            prefixSum[r2 + 1][c2 + 1] += degree;
        }

        // 가로 누적합
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                prefixSum[r][c + 1] += prefixSum[r][c];
            }
        }

        // 세로 누적합
        for (int c = 0; c < M; c++) {
            for (int r = 0; r < N; r++) {
                prefixSum[r + 1][c] += prefixSum[r][c];
            }
        }

        return prefixSum;
    }

    private void applyPrefixSum(int[][] board, int[][] prefixSum) {
        int N = board.length;
        int M = board[0].length;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                board[r][c] += prefixSum[r][c];
            }
        }
    }

    private int getValidCnt(int[][] board) {
        int cnt = 0;

        for (int[] row : board) {
            for (int cell : row) {
                if (cell > 0)
                    cnt++;
            }
        }

        return cnt;
    }
}
