import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] graph;
    private static boolean[] visited;
    private static boolean[] finished;
    private static int teamCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            graph = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            teamCount = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            sb.append(N - teamCount).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int node) {
        visited[node] = true;
        int next = graph[node];

        if (!visited[next]) {
            dfs(next);
        }
        else if (!finished[next]) {
            // 사이클을 발견했을 때
            teamCount++;
            for (int i = next; i != node; i = graph[i]) {
                teamCount++;
            }
        }

        finished[node] = true;
    }
}