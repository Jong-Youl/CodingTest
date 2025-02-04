import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int sx, int sy, int ex, int ey) {
        int answer = 0;
        // 벽을 타고 이동할 수 있음 -> 캐릭터 위치 상하좌우에 항상 도형이 붙어있어야함
        // 안에 한칸 파여있고 바로 윗칸에 테두리가 위치한다면 바로 넘어가는 버그가 있음
        // 문제 설명 1번 3,5 -> 3,6
        // 이 버그를 잡아야함 -> 도형 크기 2배 확대 -> 결과 나올때 나누기 2만 해주면 오케이 점프 버그도 없음
        int size = 101;
        // 테두리는 1, 사람이 지나가는길 2
        int [][] map = new int [size][size];
        
        for(int i = 0 ; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            markingMap(map, x1, y1, x2, y2);
        }
        
        answer = bfs(map, sx * 2, sy * 2, ex * 2, ey * 2) + 1;
        return answer;
    }
    
    public int bfs(int [][] map, int sx, int sy, int ex, int ey) {
        int [] dr = {-1, 1, 0, 0};
        int [] dc = {0, 0, -1, 1};
        
        boolean [][] visit = new boolean [map.length][map.length];
        Queue<int []> q = new LinkedList<>();
        
        visit[sx][sy] = true;
        q.add(new int [] {sx, sy, 0});
        
        while(!q.isEmpty()) {
            int [] curr = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                
                if(nr == ex && nc == ey) return curr[2] / 2;
                if(nr < 0 || nr > 100 || nc < 0 || nc > 100) continue;
                //사람이 간 적이 없어야함
                if(map[nr][nc] == 1 && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    q.add(new int [] {nr, nc, curr[2] + 1});
                }
            }
        }
        return 0;
    }
    
    public void markingMap(int [][] map, int sx, int sy, int ex, int ey) {
        for(int r = sx; r <= ex; r++) {
            for(int c = sy; c <= ey; c++) {
               if(r == sx || r == ex || c == sy || c == ey) {
                    if(map[r][c] == 0)
                        map[r][c] = 1;    
                }
                else
                    map[r][c] = 2;
            }
        }
    }
}