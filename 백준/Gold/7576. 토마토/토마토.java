import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(simultion());
    }
    private static boolean checkIndex(int r, int c) {
        return r < N && r >= 0 && c < M && c >= 0;
    }
    private static int simultion() {
        int time = 0;
        boolean [][] visit = new boolean [N][M];

        PriorityQueue<Tomato> q = new PriorityQueue<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(map[r][c] == 1) {
                    visit[r][c] = true;
                    q.add(new Tomato(r, c, 0));
                }
            }
        }
        while (!q.isEmpty()) {
            Tomato tmp = q.poll();

            time = Math.max(time, tmp.time);

            for(int i = 0; i < dr.length; i++){
                int nr = tmp.r + dr[i];
                int nc = tmp.c + dc[i];

                if(checkIndex(nr, nc) && map[nr][nc] == 0 && !visit[nr][nc]) {
                    map[nr][nc] = 1;
                    visit[nr][nc] = true;
                    q.add(new Tomato(nr, nc, tmp.time + 1));
                }
            }
        }

        boolean isFinished = checkTomato();
        if (isFinished) return time;
        return -1;
    }

    private static boolean checkTomato() {
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(map[r][c] == 0) return false;
            }
        }
        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }

        }
    }

    private static class Tomato implements Comparable <Tomato>{
        int r, c, time;

        private Tomato(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

        @Override
        public int compareTo(Tomato o) {
            return time - o.time;
        }
    }
}