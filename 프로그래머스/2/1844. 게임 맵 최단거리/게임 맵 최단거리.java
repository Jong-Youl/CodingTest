import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int row = maps.length;
        int col = maps[0].length;
        
        int [] dr = {-1, 1, 0, 0};
        int [] dc = {0, 0, -1, 1};        
        boolean [][] visit = new boolean [row][col];
        visit[row - 1][col - 1] = true;
        
        // 시작점, 움직인 수
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {row - 1, col - 1, 1});
        
        while(!q.isEmpty()) {
            int [] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int cnt = curr[2];
            
            if(r == 0 && c == 0) {
                answer = cnt;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                // 인덱스, 방문처리, 벽 확인
                if(nr >= 0 && nr < row && nc >= 0 && nc < col && !visit[nr][nc] && maps[nr][nc] == 1) {
                    visit[nr][nc] = true;
                    q.add(new int [] {nr, nc, cnt + 1});
                }
            }
        }
        
        return answer;
    }
}