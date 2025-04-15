import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        int total = n * (n + 1) / 2;

        int r = 0, c = 0, num = 1, dir = 0;
        int[] dr = {1, 0, -1};
        int[] dc = {0, 1, -1};

        while (num <= total) {
            map[r][c] = num++;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 0) {
                r = nr;
                c = nc;
            } else {
                dir = (dir + 1) % 3;
                r += dr[dir];
                c += dc[dir];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= i; j++)
                result.add(map[i][j]);
        
        int [] answer = new int [result.size()];
        for (int i = 0; i < result.size(); i++)
            answer[i] = result.get(i);
        
        return answer;
    }
}
