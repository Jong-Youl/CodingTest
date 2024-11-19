import java.util.*;

class Solution {
    
    public class Pos {
        int r, c, cnt;
        
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
            this.cnt = 0;
        }
        
        Pos(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    public int solution(String[] board) {
        int result = -1;
        int n = board.length;
        int m = board[0].length();
        
        char [][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m]; // 방문 체크
        int [] dr = {-1, 1, 0, 0};
        int [] dc = {0, 0, -1, 1};
        
        // BFS 준비
        Queue<Pos> q = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            String curr = board[r];
            for (int c = 0; c < m; c++) {
                map[r][c] = curr.charAt(c);
                if (map[r][c] == 'R') {
                    q.add(new Pos(r, c));
                    visited[r][c] = true;
                }
            }
        }
        
        // BFS 탐색
        p: while (!q.isEmpty()) {
            Pos curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            
            for (int i = 0; i < 4; i++) {
                int nr = r, nc = c;
                while (true) {
                    nr += dr[i];
                    nc += dc[i];
                    
                    // 범위 밖이거나 장애물에 부딪힌 경우
                    if (!isValid(nr, nc, n, m) || map[nr][nc] == 'D') {
                        nr -= dr[i];
                        nc -= dc[i];
                        break;
                    }
                }
                
                if (visited[nr][nc] || (nr == curr.r && nc == curr.c)) {
                    continue;
                }
                
                if (map[nr][nc] == 'G') {
                    result = curr.cnt + 1;
                    break p;
                }
                
                visited[nr][nc] = true;
                q.add(new Pos(nr, nc, curr.cnt + 1));
            }
        }
        
        return result;
    }
    
    public boolean isValid(int nr, int nc, int r, int c) {
        return nr >= 0 && nr < r && nc >= 0 && nc < c;
    }
}
