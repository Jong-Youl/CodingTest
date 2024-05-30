import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static final long inf = Long.MAX_VALUE;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		boolean[] visible = new boolean[N];
		for(int i = 0; i < N - 1; i++) {
			if(Integer.parseInt(st.nextToken()) == 1) {
				visible[i] = true;
			}
		}

		List<List<Node>> graph = new ArrayList<>();

		for(int i = 0; i < N; i++)
			graph.add(new ArrayList<>());
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());

			//둘 중에 하나라도 보이는 경우에
			if(visible[v1] || visible[v2]) continue;
			graph.get(v1).add(new Node(v2 ,edge));
			graph.get(v2).add(new Node(v1 ,edge));
		}

		dijkstra(graph);
	}

	private static void  dijkstra(List<List<Node>> graph) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean [] visit = new boolean [N];
		long [] dist = new long [N];

		Arrays.fill(dist, inf);
		visit[0] = true;
		dist[0] = 0;

		pq.addAll(graph.get(0));

		while (!pq.isEmpty()) {
			Node tmp = pq.poll();

			if (visit[tmp.v]) continue;
			visit[tmp.v] = true;
			dist[tmp.v] = tmp.e;
			for(Node next : graph.get(tmp.v)) {
				pq.add(new Node(next.v, tmp.e + next.e));
			}
		}
		long result = dist[N - 1] == inf? -1:dist[N - 1];
		System.out.println(result);
	}
	public static class Node implements Comparable<Node>{
		int  v;
		long e;
		public Node(int v, long e) {
			this.v = v;
			this.e = e;
		}
		@Override
		public int compareTo(Node o) {
			if(e == o.e) return v - o.v;
			return (int)(e - o.e);
		}

		@Override
		public String toString() {
			return "Node{" +
				"v=" + v +
				", e=" + e +
				'}';
		}
	}
}