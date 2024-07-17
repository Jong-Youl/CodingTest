import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int N, M, min;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static char [][] map;
    private static boolean [][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        N = Integer.parseInt(str.split(" ")[0]);
        M = Integer.parseInt(str.split(" ")[1]);
        min = Integer.MAX_VALUE;

        map = new char[N][M];
        visit = new boolean[N][M][64];
        int sr = 0;
        int sc = 0;

        for (int r = 0; r < N; r++) {
            str = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c);
                if (map[r][c] == '0') {
                    sr = r;
                    sc = c;
                }
            }
        }
        bfs(sr, sc);
        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }

    private static void bfs(int sr, int sc) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(sr, sc));
        visit[sr][sc][0] = true;

        while(!q.isEmpty()) {
            Pos tmp = q.poll();

            if(map[tmp.r][tmp.c] == '1') {
                min = Math.min(min, tmp.cnt);
                return;
            }

            for(int i = 0; i < dr.length; i++) {
                int r = tmp.r + dr[i];
                int c = tmp.c + dc[i];

                if(!checkIndex(r, c) || map[r][c] == '#' || visit[r][c][tmp.keys]) {
                    continue;
                }

                if(map[r][c] == '.' || map[r][c] == '0' || map[r][c] == '1') {
                    q.add(new Pos(r, c, tmp.cnt + 1, tmp.keys));
                    visit[r][c][tmp.keys] = true;
                }

                if(map[r][c]>= 'a' && map[r][c] <= 'z'){
                    int keys = tmp.keys | (1 << getKey(map[r][c]));
                    if(!visit[r][c][keys]) {
                        q.add(new Pos(r, c, tmp.cnt + 1, keys));
                        visit[r][c][keys] = true;
                    }
                }

                if(map[r][c] >= 'A' && map[r][c] <= 'Z' && tmp.hasKey(map[r][c])) {
                    q.add(new Pos(r, c, tmp.cnt + 1, tmp.keys));
                    visit[r][c][tmp.keys] = true;
                }
            }
        }
    }

    private static int getKey(char Alpha) {
        return Alpha - 'a';
    }

    private static boolean checkIndex(int r, int c) {
        return r < N && c < M && r >= 0 && c >= 0;
    }
    private static class Pos {
        int r, c, cnt, keys;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
            this.cnt = 0;
            this.keys = 0;
        }

        Pos(int r, int c, int cnt, int keys) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.keys = keys;
        }

        boolean hasKey(char alpha) {
            int num = alpha - 'A';
            return (keys & (1 << num)) != 0;
        }
    }
}