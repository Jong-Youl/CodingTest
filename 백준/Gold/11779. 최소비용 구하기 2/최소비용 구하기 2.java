import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int v,e;
		
		Node(int v, int e){
			this.v = v;
			this.e = e;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.e - o.e;
		}
		
	}

	public static void main(String[] args) throws IOException {
		//init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		List<List<Node>> graph = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		// 그래프 정점 생성
		for(int i = 0; i <= n; i++)
			graph.add(new ArrayList<>());
		// 간선 입력 - 양방향
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(new Node(v2, edge));
		}
		
		// 시작 정점, 도착 정점 선택
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		// 거리 배열 초기화
		int [] dist = new int [n + 1];
		int [] prev = new int [n + 1];
		int inf = 987654321;
		Arrays.fill(prev, -1);
		for(int i = 1; i <= n; i++)
			dist[i] = (i==start) ? 0 : inf;  
		dist[start] = 0;

		//djikstra
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			// 지금까지 쌓아온 비용이 최소값이 아니면 그냥 out
			if(curr.e > dist[curr.v])
				continue;
			
			for(int i = 0; i < graph.get(curr.v).size(); i++) {
				Node next = graph.get(curr.v).get(i);
				// 다음 노드의 최단거리보다 작으면
				if(dist[curr.v] + next.e < dist[next.v]) {
					dist[next.v] = dist[curr.v] + next.e;
					prev[next.v] = curr.v;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
		System.out.println(dist[end]);
		
		List<Integer> path = new ArrayList<>();
		for(int v = end; v!= -1; v = prev[v]) {
			path.add(v);
		}
		Collections.reverse(path);
		System.out.println(path.size());
        for (int v : path) {
            System.out.print(v + " ");
        }
	}
}