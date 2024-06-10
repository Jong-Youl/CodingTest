import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Shark baby;
    private static int N;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 9) {
                    baby = new Shark(r, c);
                    map[r][c] = 0;
                }
            }
        }

        int result = simulation();
        System.out.println(result);
    }

    private static int simulation() {
        int time = 0;
        Pos target;
        while (true) {
            target = searchFeed();
            if (target.r == -1 && target.c == -1) break;
            time += target.dist;
        }

        return time;
    }

    private static Pos searchFeed() {
        Queue<Pos> q = new LinkedList<>();
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        boolean[][] visit = new boolean[N][N];

        q.add(new Pos(baby.r, baby.c, 0));
        visit[baby.r][baby.c] = true;

        while (!q.isEmpty()) {
            Pos tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = tmp.r + dr[i];
                int nc = tmp.c + dc[i];

                if (checkIndex(nr, nc) && !visit[nr][nc] && map[nr][nc] <= baby.size) {
                    visit[nr][nc] = true;
                    q.add(new Pos(nr, nc, tmp.dist + 1));

                    if (map[nr][nc] != 0 && map[nr][nc] < baby.size) {
                        pq.add(new Pos(nr, nc, tmp.dist + 1));
                    }
                }
            }
        }

        if (pq.isEmpty()) return new Pos(-1, -1, 0);
        else {
            Pos result = pq.poll();
            baby.eatFeed();
            baby.setPos(result.r, result.c);
            map[result.r][result.c] = 0;
            return result;
        }
    }

    private static boolean checkIndex(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static class Shark {
        int r, c, size, cnt;

        private Shark(int r, int c) {
            this.r = r;
            this.c = c;
            size = 2;
            cnt = 0;
        }

        private void eatFeed() {
            cnt++;
            if (cnt == size) {
                cnt = 0;
                size++;
            }
        }

        private void setPos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", size=" + size +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    private static class Pos implements Comparable<Pos> {
        int r, c, dist;

        private Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.dist != o.dist) return this.dist - o.dist; // 거리 우선
            if (this.r != o.r) return this.r - o.r; // 같은 거리일 때, 행 우선
            return this.c - o.c; // 같은 행일 때, 열 우선
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "r=" + r +
                    ", c=" + c +
                    ", dist=" + dist +
                    '}';
        }
    }
}