import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class vertex implements Comparable<vertex>{
	int v; //출발 정점
	int u; //도착 정점
	
	public vertex() {

	}
	
	public vertex(int v, int u) {
		this.v = v;
		this.u = u;
	}

	@Override
	public int compareTo(vertex o) {
		// TODO Auto-generated method stub
		if(v == o.v) {
			return u - o.u;
		}
		
		return v - o.v;
	}

	@Override
	public String toString() {
		return "vertex [v=" + v + ", u=" + u + "]";
	}
	
	
	
}

public class Main {
	
	public static int N, M, cnt;
	public static int [] order;
	public static boolean [] visit;
	public static List<List<vertex>> graph = new ArrayList<>();
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//정점의 개수
		M = Integer.parseInt(st.nextToken());//간선의 개수
		int start = Integer.parseInt(st.nextToken());//시작 정점
		
		order = new int [N+1];
		visit = new boolean [N+1];
		
		for(int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<vertex>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			vertex tmp1 = new vertex(v1, v2);
			vertex tmp2 = new vertex(v2, v1);
			graph.get(v1).add(tmp1);
			graph.get(v2).add(tmp2);
		}
		for(int i = 1; i < N+1; i++) {
			Collections.sort(graph.get(i));
		}
//		System.out.println(graph.toString());
		
		cnt = 1;
		dfs(start);
		
		for(int i = 1; i < order.length; i++) {
			System.out.println(order[i]);
		}
	}
	
	public static void dfs(int start) {
		//언제 끝?
		//이미 방문했거나
		//더이상 연결 된 노드가 없으면 끝
		
		visit[start] = true;
		order[start] = cnt;
		
		for(int i = 0; i < graph.get(start).size(); i++) {
			int next = graph.get(start).get(i).u;
			
			if(!visit[next]) {
				cnt++;
//				System.out.println("next : " + next + "cnt : " + cnt);
				dfs(next);
			}
		}
	}
}