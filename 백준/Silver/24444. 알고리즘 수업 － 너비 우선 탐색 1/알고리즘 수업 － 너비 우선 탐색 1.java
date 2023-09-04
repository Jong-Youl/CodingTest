import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static class Vertex implements Comparable<Vertex>{
		int v, u;

		public Vertex(int v, int u) {
			super();
			this.v = v;
			this.u = u;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			if(v == o.v) {
				return u - o.u;
			}
			return v - o.v;
		}
		
	}
	
	
	public static int N, M;
	public static boolean [] visit;
	public static int [] order;
	public static List<List<Vertex>> graph = new ArrayList<>(); 
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		visit = new boolean [N+1];
		order = new int [N+1];
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Vertex>());
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			
			graph.get(v).add(new Vertex(v, u));
			graph.get(u).add(new Vertex(u, v));
		}
		//오름차순 정렬
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}
		
		bfs(start);
		
		for(int i = 1; i <= N; i++) {
			System.out.println(order[i]);;
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		int cnt = 1;
		q.add(start);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			if(visit[tmp]) {//방문했다면
				continue;//다음
			}
			visit[tmp] = true;
			//아니면
			
			order[tmp] = cnt++;
			
			for(int i = 0; i < graph.get(tmp).size(); i++) {
				int v = graph.get(tmp).get(i).u;
				q.add(v);
			}	
		}
	}
}