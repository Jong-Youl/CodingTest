import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] copy = new int[N][M];

        initializeMap(br, N, M, map, copy);

        int year = runSimulation(map, copy, N, M);

        System.out.println(year);
    }

    public static void initializeMap(BufferedReader br, int N, int M, int[][] map, int[][] copy) throws IOException {
        StringTokenizer st;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                copy[r][c] = map[r][c];
            }
        }
    }

    public static int runSimulation(int[][] map, int[][] copy, int N, int M) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int year = 0;

        while (true) {
            meltIcebergs(map, copy, N, M, dr, dc);
            year++;

            if (!checkIceExist(copy, N, M)) {
                return 0;
            }

            if (checkSeparation(copy, N, M)) {
                break;
            }

            updateMap(map, copy, N, M);
        }

        return year;
    }

    public static void meltIcebergs(int[][] map, int[][] copy, int N, int M, int[] dr, int[] dc) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] != 0) {
                    int cnt = 0;
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i], nc = c + dc[i];
                        if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                        if (map[nr][nc] == 0) cnt++;
                    }
                    copy[r][c] = Math.max(copy[r][c] - cnt, 0);
                }
            }
        }
    }

    public static boolean checkIceExist(int[][] copy, int N, int M) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (copy[r][c] != 0) return true;
            }
        }
        return false;
    }

    public static void updateMap(int[][] map, int[][] copy, int N, int M) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = copy[r][c];
            }
        }
    }

    public static boolean checkSeparation(int[][] map, int N, int M) {
        boolean[][] visited = new boolean[N][M];
        int icebergCount = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] != 0 && !visited[r][c]) {
                    if (++icebergCount > 1) return true;
                    bfs(map, visited, r, c, N, M);
                }
            }
        }
        return false;
    }

    public static void bfs(int[][] map, boolean[][] visited, int r, int c, int N, int M) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cr = curr[0];
            int cc = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i], nc = cc + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] != 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}