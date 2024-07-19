import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, max;
    public static int [] dr = {-1, 1, 0, 0};
    public static int [] dc = {0, 0, -1, 1};
    public static int [][] map;
    public static boolean [][] visit;

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = 0;
        map = new int [N][M];
        visit = new boolean[N][M];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                visit[r][c] = true;
                checkTetromino(r, c, 0, 0);
                visit[r][c] = false;
                checkExceptionTetromino(r, c);
            }
        }
        System.out.println(max);
    }

    private static void checkTetromino(int r, int c, int depth, int sum) {
        if(depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        sum += map[r][c];

        for(int i = 0; i < dr.length; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if(checkIndex(nr, nc) && !visit[nr][nc]) {
                visit[nr][nc] = true;
                checkTetromino(nr, nc, depth + 1, sum);
                visit[nr][nc] = false;
            }
        }
    }

    private static void checkExceptionTetromino(int r, int c) {
        if (r >= 1 && c >= 1 && c < M - 1) {
            int sum = map[r][c] + map[r-1][c] + map[r][c-1] + map[r][c+1];
            max = Math.max(max, sum);
        }
        if (r >= 1 && r < N - 1 && c < M - 1) {
            int sum = map[r][c] + map[r-1][c] + map[r+1][c] + map[r][c+1];
            max = Math.max(max, sum);
        }
        if (c >= 1 && r < N - 1 && c < M - 1) {
            int sum = map[r][c] + map[r][c-1] + map[r+1][c] + map[r][c+1];
            max = Math.max(max, sum);
        }
        if (r >= 1 && r < N - 1 && c >= 1) {
            int sum = map[r][c] + map[r-1][c] + map[r+1][c] + map[r][c-1];
            max = Math.max(max, sum);
        }
    }

    private static boolean checkIndex(int r, int c) {
        return r < N && c < M && r >= 0 && c >= 0;
    }

}