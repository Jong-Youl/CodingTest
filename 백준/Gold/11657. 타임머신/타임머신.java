import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Vertex implements Comparable<Vertex>{
	
	int v;//시작 정점
	int u;//도착 정점
	int e;//간선 정보
	
	public Vertex(int v, int u, int e) {
		// TODO Auto-generated constructor stub
		this.v = v;
		this.u = u;
		this.e = e;
	}

	@Override
	public int compareTo(Vertex o) {
		// TODO Auto-generated method stub
		return u - o.u;
	}

	@Override
	public String toString() {
		return "Vertex [v=" + v + ", u=" + u + ", e=" + e + "]";
	}
	
	
}

public class Main {
	
	public static StringTokenizer st;
	public static List<Vertex>graph;
	public static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//도시의 수 (정점의 갯수)
		M = Integer.parseInt(st.nextToken());//버스의 수 (간선의 갯수)
		graph = new ArrayList<>();
		
		
		
		for(int i = 0; i < M; i++) {//idx를 시작 정점으로 쓸 계획
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());//출발 도시(시작 정점)
			int B = Integer.parseInt(st.nextToken());//도착 도시(도착 정점)
			int C = Integer.parseInt(st.nextToken());//걸린 시간(간선 정보)
			
			Vertex v = new Vertex(A, B, C);
			graph.add(v);
		}
		
//		for(int i = 0; i < M; i++) {//idx를 0부터 N까지 가지게
//			System.out.println(graph.get(i).toString());
//		}
		
		Bellman_Ford(1);//시작점은 무조건 1
		
	}
	
	public static void Bellman_Ford(int start) {
		//여기까지 지찬이의 다익스트라랑 같음
		int max = Integer.MAX_VALUE;
		long [] bf_dist = new long [N+1];//정점의 개수만큼
		
		Arrays.fill(bf_dist, max);//
		bf_dist[start] = 0;//자기 자신으로 돌아오는 로터리간선 x
		//방문처리 X
		
		for(int i = 0; i < N; i++) {//1
			for(int j = 0; j < M; j++) {//2
				Vertex tmp = graph.get(j);// 지금 정점 이동 정보(어디서 어디 가는지 시간은 얼마인지)
				
				if(bf_dist[tmp.v] != max && bf_dist[tmp.u] > bf_dist[tmp.v]+tmp.e) {
					//시작 정점부터 현재 정점까지의 거리가 max가 아니고
					//동시에 시작점부터 현재 도착점까지의 최단 거리가 현재 정점까지의 거리에서 지금 이동하는 거리의 합보다
					//크면
					bf_dist[tmp.u] = bf_dist[tmp.v] + tmp.e;
					
				}
			}
		}
		
		//해당 과정까지만 수행해도 왠만하면 만족
		//but 음수의 순환이 존재하는 경우에는 어려움
		
		//음수 간선의 순환 확인
		//2번 과정을 1회 더 함
		for(int j = 0; j < M; j++) {//2
			Vertex tmp = graph.get(j);// 지금 정점 이동 정보(어디서 어디 가는지 시간은 얼마인지)
			
			if(bf_dist[tmp.v] != max && bf_dist[tmp.u] > bf_dist[tmp.v]+tmp.e) {
				//시작 정점부터 현재 정점까지의 거리가 max가 아니고
				//동시에 시작점부터 현재 도착점까지의 최단 거리가 현재 정점까지의 거리에서 지금 이동하는 거리의 합보다
				//크면
				System.out.println(-1);
				return;
			}
		}
	
		//if를 빠져나온다면
		//각 정점으로 가는 최단 거리를 출력
		for(int i = 1; i < bf_dist.length; i++) {
			if(i == start) {
				continue;
			}
			if(bf_dist[i] == max) {
				//초기화를 못해줬으면
				System.out.println(-1);
			}
			else
				System.out.println(bf_dist[i]);
		}
	}
	
}