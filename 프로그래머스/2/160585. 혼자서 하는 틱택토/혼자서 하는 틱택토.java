class Solution {
    public int solution(String[] board) {
        int oCnt = 0, xCnt = 0;
        char[][] map = new char[3][3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'O') oCnt++;
                else if (map[i][j] == 'X') xCnt++;
            }
        }
        
        // X -> O보다 클 수 없음, O ->  X + 1 보다 클 수 없음
        if (xCnt > oCnt || oCnt > xCnt + 1) return 0;
        
        boolean oWin = isWin(map, 'O');
        boolean xWin = isWin(map, 'X');
        
        // 승리 조건 검증
        if (oWin && xWin) return 0; // O와 X가 동시에 승리할 수 없음
        if (oWin && oCnt != xCnt + 1) return 0; // O가 이겼다면 O가 더 많아야 함
        if (xWin && oCnt != xCnt) return 0; // X가 이겼다면 O와 X가 같아야 함
        
        return 1;
    }
    
    // 승리 조건 확인
    public boolean isWin(char[][] map, char player) {
        // 가로, 세로, 대각선 체크
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == player && map[i][1] == player && map[i][2] == player) return true; // 가로
            if (map[0][i] == player && map[1][i] == player && map[2][i] == player) return true; // 세로
        }
        if (map[0][0] == player && map[1][1] == player && map[2][2] == player) return true; // 대각선 좌상->우하
        if (map[0][2] == player && map[1][1] == player && map[2][0] == player) return true; // 대각선 우상->좌하
        
        return false;
    }
}
