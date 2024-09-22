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

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        //init - start
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] copy = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                copy[r][c] = map[r][c];
            }
        }
        // init - end

        //simulation
        int year = 0;
        while (true) {
            // 빙산 녹이기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] != 0) {
                        int cnt = 0;
                        for (int i = 0; i < 4; i++) {
                            int nr = r + dr[i], nc = c + dc[i];

                            // checkIndex
                            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                            if (map[nr][nc] == 0) cnt++;
                        }

                        if (copy[r][c] < cnt)
                            copy[r][c] = 0;
                        else
                            copy[r][c] -= cnt;
                    }
                }
            }
            year++;

            // 빙산이 남아있는지 확인
            boolean isExist = false;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (copy[r][c] != 0) {
                        isExist = true;
                        break;
                    }
                }
            }

            if (!isExist) {  // 모든 빙산이 녹았다면
                year = 0;
                break;
            }

            // 빙산이 분리되었는지 확인
            if (checkSeparation(copy, N, M)) {
                break;
            }

            // map 갱신
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    map[r][c] = copy[r][c];
                }
            }
        }

        System.out.println(year);
    }

    // 빙산이 분리되었는지 확인하는 함수
    public static boolean checkSeparation(int[][] map, int N, int M) {
        boolean[][] visited = new boolean[N][M];
        int icebergCount = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] != 0 && !visited[r][c]) {
                    if (++icebergCount > 1) return true;  // 2개 이상의 덩어리가 있으면 분리된 것
                    bfs(map, visited, r, c, N, M);
                }
            }
        }
        return false;// 분리되지 않음
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

                // checkIndex
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] != 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}