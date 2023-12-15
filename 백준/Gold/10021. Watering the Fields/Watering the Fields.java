import java.io.*;
import java.util.*;

/*
 * 제한시간 1초
 * 1 <= N <= 2000
 * 
 * */

public class Main {
	
	final static int inf = 123456789;
	public static int N, C;
	public static Pos [] pos;
	public static int [] cost;
	public static boolean [] visit;
	public static List<List<fields>> graph;

	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		// 밭의 개수
		N = Integer.parseInt(st.nextToken());
		// 밭 - 밭의 최소 연결 비용(이것도 안하면 장사 안함!)
		C = Integer.parseInt(st.nextToken());	
		
		/*			
		 * 1. 각각의 밭의 위치 
		 * 2. 수도선이 연결되었는지 여부
		 * 3. 비용 
		 * */ 
		pos = new Pos[N+1];
		visit = new boolean [N+1];
		cost = new int [N+1];
		graph = new ArrayList<>();
		
		Arrays.fill(cost, inf);
		cost[0] = 0;
		
		//밭의 좌표 입력 
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			Pos tmp = new Pos(x, y);
			
			pos[i] = tmp;
		}
		
		//그래프 구성
		//정점 구현
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		//간선 구현(최소 비용 C를 넘기는 비용의 간선만 추가)
		for(int i = 1; i <= N-1; i++) {
			for(int j = i; j <= N; j++) {
				if(i == j) continue;
				
				int x1 = pos[i].x;
				int y1 = pos[i].y;
				int x2 = pos[j].x;
				int y2 = pos[j].y;
				
				int dist = calculateDist(x1, y1, x2, y2);

				if(C <= dist) {
					graph.get(i).add(new fields(j, dist));
					graph.get(j).add(new fields(i, dist));	
				}
				
			}
		}
		
		//최소 간선을 가지는 정점을 탐색 ㄱㄱ
		searching();
		//비용계산
		int result = 0;
		
		for(int c : cost) {
			// 만약 연결 못한곳이 있다면
			if(c == inf) {
				result = -1;
				break;
			}
			// 아니면
			result += c;
		}
		
		System.out.println(result);
	}
	
	//프림 알고리즘 기반의 간선 연결 메소드
	private static void searching() {
		PriorityQueue<fields> pq = new PriorityQueue<>();
		
		//시작 정점은 1번 밭부터
		//시작 정점 체크해주기
		visit[1] = true;
		cost[1] = 0;
		
		//1번 정점과 연결된 모든 간선을 pq에 추가함
		//메소드를 쓰면 호출로 인해 속도가 느려지지만 간편해서 씀 
		pq.addAll(graph.get(1));
		
		// 최소 동작을 위한 cnt
		int cnt = 0;
		
		// 쓸모 없는 순회를 방지하기 위해 모든 간선을 찾은 경우에 더 이상의 동작 X
		while(cnt != N-1) {
			//만약 간선을 다 연결하기 전에 pq가 비어버린다면 MST를 만들 수 없기 때문에 그대로 종료한다.
			if(pq.isEmpty()) break;
			
			fields tmp = pq.poll();
			//간적 없다면
			if(!visit[tmp.v]) {
				cnt++;
				//방문 체크 후 간선 비용 기입
				visit[tmp.v] = true;
				cost[tmp.v] = tmp.dist;
				
				// 추가로 이동한 정점의 간선들도 pq에 추가
				pq.addAll(graph.get(tmp.v));
				
			}
		}
		
	}

	//거리 비용 구하는 메소드
	public static int calculateDist(int x1, int y1, int x2, int y2) {
		
		return (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);

	}
	
	public static class Pos{
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	// 밭을 긓래프로 구현하기 위해 노드를 표현할 클래스
	public static class fields implements Comparable<fields>{
		// 도착점, 거리비용
		int v, dist;

		public fields(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}

		@Override
		public int compareTo(fields o) {
			return dist - o.dist;
		}		
		
	}
	
	
}