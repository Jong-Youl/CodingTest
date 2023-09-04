import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Vertex{
	int v, u, e;

	public Vertex(int v, int u, int e) {
		super();
		this.v = v;
		this.u = u;
		this.e = e;
	}

	@Override
	public String toString() {
		return "Vertex [v=" + v + ", u=" + u + ", e=" + e + "]";
	}
	
	
}

class Edge implements Comparable<Edge>{
	int v;
	int e;
	
	public Edge(int v, int e) {
		super();
		this.v = v;
		this.e = e;
	}

	@Override
	public int compareTo(Edge o) {//거리 기준으로 오름차순 정렬
		// TODO Auto-generated method stub
		return e - o.e;
	}
	
	
}
public class Main {
	
	public static StringTokenizer st;
	public static int N, M;//정점의 개수, 간선의 개수
	public static int max = Integer.MAX_VALUE-1;
	public static int [] d_dist;
	public static boolean [] visit;
	public static ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//정점의 개수
		M = Integer.parseInt(st.nextToken());//간선의 개수
		
		int start = Integer.parseInt(br.readLine());
		
		//최단 경로를 저장할 배열 생성
		d_dist = new int [N+1];
		Arrays.fill(d_dist, max);
		d_dist[start] = 0;
		
		//정점의 최단거리를 저장했는지 여부에 대한 정보를 담는 배열
		visit = new boolean [N+1];
		
		//그래프 공간 생성(정점 N까지)
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Vertex>());
		}
		
		//간선 정보를 그래프 공간에 입력
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			Vertex tmp = new Vertex(v, u, e);
			
			graph.get(v).add(tmp);
		}
		
		dijkstra(start);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(d_dist[i] == max) {//처음 초기화한 값이 갱신되지 않는다
				//최단 경로를 찾지 못했다 or 해당 정점까지 도달할 방법이 없다
				sb.append("INF\n");//Inf로 표기
			}
			else
				sb.append(d_dist[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {//pq안에 모든 숫자가 없어질때까지
			
			Edge tmp = pq.poll();
			
			if(visit[tmp.v])//현재 정점이 최단 경로를 찾았다면
				continue;
			
			visit[tmp.v] = true;
			//최단 경로를 찾지 못했다면
			for(int i = 0; i < graph.get(tmp.v).size(); i++) {
				int v = graph.get(tmp.v).get(i).u;//현재 정점에서 갈 수 있는 다음 정점
				int e = graph.get(tmp.v).get(i).e;//그 정점까지 가는 거리
				
				if(d_dist[v] > d_dist[tmp.v] + e) {//현재 저장된 값이 갱신할 값보다 크면
					d_dist[v] = d_dist[tmp.v] + e;
				}
				
				pq.add(new Edge(v, d_dist[v]));
			}
			
			
		}
	}
}