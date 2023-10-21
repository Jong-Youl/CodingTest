import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static class Node implements Comparable<Node>{
		int v, e;

		public Node(int v, int e) {
			this.v = v;
			this.e = e;
		}

		@Override
		public int compareTo(Node o) {
			return e - o.e;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int inf = 987654321;
		
		boolean [] visit = new boolean [N+1];
		int [] dist = new int [N+1];
		int [] route = new int [N+1];
		List<List<Node>> graph = new ArrayList<>();
		
		
		for(int i = 0; i <= N; i++) {
			dist[i] = inf;
			graph.add(new ArrayList<>());
		}
		
		dist[1] = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());//출발 컴퓨터
			int B = Integer.parseInt(st.nextToken());//도착 컴퓨터
			int C = Integer.parseInt(st.nextToken());//속도
			
			graph.get(A).add(new Node(B, C));
			graph.get(B).add(new Node(A, C));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visit[cur.v]) continue;
			visit[cur.v] = true;
			
			
			for(Node n : graph.get(cur.v)) {
				if(dist[cur.v] + n.e < dist[n.v]) {
					dist[n.v] = dist[cur.v] + n.e;
					route[n.v] = cur.v;
					pq.add(new Node(n.v, dist[n.v]));
				}
			}
		}
		
		sb.append(N-1).append("\n");
		
		for(int i = 2; i <= N; i++) {
			sb.append(route[i]).append(" ").append(i).append("\n");
		}
		
		System.out.println(sb);
	}
}