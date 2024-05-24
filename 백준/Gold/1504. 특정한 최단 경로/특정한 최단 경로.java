import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static final int inf = 123456789;
	public static int N, E, vertex1, vertex2;
	public static List<List<Node>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());

			graph.get(v1).add(new Node(v2, edge));
			graph.get(v2).add(new Node(v1, edge));
		}

		st = new StringTokenizer(br.readLine());
		vertex1 = Integer.parseInt(st.nextToken());
		vertex2 = Integer.parseInt(st.nextToken());

		long result1 = dijkstra(1, vertex1) + dijkstra(vertex1, vertex2) + dijkstra(vertex2, N);
		long result2 = dijkstra(1, vertex2) + dijkstra(vertex2, vertex1) + dijkstra(vertex1, N);

		long answer = Math.min(result1, result2);

		if (answer >= inf)
			answer = -1;

		sb.append(answer);
		System.out.println(sb);
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		int[] tmpDist = new int[N + 1];
		Arrays.fill(tmpDist, inf);
		tmpDist[start] = 0;
		pq.addAll(graph.get(start));

		while (!pq.isEmpty()) {

			Node tmp = pq.poll();

			if (tmpDist[tmp.v] == inf || tmpDist[tmp.v] > tmp.e) {
				tmpDist[tmp.v] = tmp.e;

				if (tmp.v == end)
					continue;

				for (int i = 0; i < graph.get(tmp.v).size(); i++) {
					Node next = graph.get(tmp.v).get(i);
					pq.add(new Node(next.v, next.e + tmp.e));
				}
			}
		}

		return tmpDist[end];
	}

	public static class Node implements Comparable<Node> {
		int v, e;

		public Node(int v, int e) {
			this.v = v;
			this.e = e;
		}

		@Override
		public int compareTo(Node o) {
			if (this.e == o.e)
				return this.v - o.v;
			return this.e - o.e;
		}
	}
}