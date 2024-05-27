import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static boolean[] check;
	public static boolean[] visit;
	public static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		if (N == 2) {
			sb.append(1 + " " + 2);
			System.out.println(sb);
			return;
		}
		graph = new ArrayList<>();
		visit = new boolean[N + 1];
		check = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < N - 2; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		sb.append(1).append(" ");

		dfs(1);
		check[1] = true;
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				sb.append(i);
				break;
			}
		}
		System.out.println(sb);
	}

	private static void dfs(int start) {
		for (int next : graph.get(start)) {
			if (!visit[next]) {
				visit[next] = true;
				check[next] = true;
				dfs(next);
			}
		}
	}
}