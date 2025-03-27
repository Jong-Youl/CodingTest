class Solution {
    int answer;
    int[] queens;
    
    public int solution(int n) {
        answer = 0;
        queens = new int[n];
        placeQueen(0, n);
        return answer;
    }

    public void placeQueen(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                queens[row] = col;
                placeQueen(row + 1, n);
            }
        }
    }

    public boolean isValid(int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queens[prevRow];

            if (prevCol == col || Math.abs(prevCol - col) == Math.abs(prevRow - row)) {
                return false;
            }
        }
        return true;
    }
}
