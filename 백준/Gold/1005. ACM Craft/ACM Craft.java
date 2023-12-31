import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Node implements Comparable<Node>{
		int v;
		int cost;

		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스
		
		for(int tc = 1; tc <=T; tc++) {			
			//N = 건물의 개수, K는 간선 정보
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			//정점의 연결갯수와 걸리는 시간 정보
			int [] dp = new int [N+1];
			int [] degree = new int [N+1];
			int [] spent = new int [N+1];
			
			List<List<Integer>> graph = new ArrayList<>();
			
			//그래프 정점 생성
			for(int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}
			
			//시간정보
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= N; i++) {
				spent[i] = Integer.parseInt(st.nextToken()); 
			}
			
			//간선 정보
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				graph.get(start).add(end);
				degree[end]++;
			}
			//목적 정점
			int last = Integer.parseInt(br.readLine());
			//탐색
			//해당 정점을 방문시 연결된 선을 지우고(--degree) 더이상 연결되지 않은 경우에 dp 배열을 이용해서 시간을 넣어줌 
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			if (degree[last] == 0) 	{
				sb.append(spent[last]).append("\n");
				continue;
			}
			
			for(int i = 1; i <= N; i++) {
				//연결된 점이 없는 곳부터 시작
				if(degree[i] == 0) {
					dp[i] = spent[i];
					for(int j = 0; j < graph.get(i).size(); j++) {
						pq.add(new Node(graph.get(i).get(j), dp[i]));
					}
				}
			}
			
			//목적정점에 도달할때까지
			while(!(degree[last] == 0)) {
				//현재 도착 정점 tmp의 연결간선 갯수 정보를 1 줄여줌
				Node tmp = pq.poll();
				degree[tmp.v]--;
				
				//0인 경우에는 방문 처리 후 담아줌
				if(degree[tmp.v] == 0) {
					dp[tmp.v] = tmp.cost + spent[tmp.v];
					for(int i = 0; i < graph.get(tmp.v).size(); i++) {
						pq.add(new Node(graph.get(tmp.v).get(i), tmp.cost + spent[tmp.v]));
					}
				}				
			}
			
			sb.append(dp[last]).append("\n");
		}
		System.out.println(sb);		
	}
}