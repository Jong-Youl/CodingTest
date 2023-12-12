import java.util.*;
import java.io.*;

public class Main {
	/*
	 * 준석이의 인싸되는 법
	 * 친구의 친구는 친구다!!(양방향 그래프)
	 * 모두와 친구가 되는 가장 적은 비용을 구해라
	 * 학생 수 (1<= N <= 10,000)
	 * 친구 관계 수 (0<= M <= 10,000)
	 * 가진 돈 (0 <= K <= 10,000,000)
	 * 
	 * A => 친구비
	 * 
	 * (주의사항)
	 * 자기 자신과 친구인 사람도 있음;;
	 * */
	static int N, M, K, result;
	static boolean [] visit;
	static int [] cost;
	static List<List<Integer>> graph = new ArrayList<>();
	static StringTokenizer st;
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//정보 입력받기
		//==================================================================================
		// 1. 학생 수 , 주어진 친구 관계 수, 가진 돈
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new boolean [N+1];
		
		// 2. 친구 비 입력
		cost = new int [N+1];// 친구 번호랑 인덱스랑 맞추기 위해서
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1 ; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		// 3. 친구 관계 입력
		// 0부터 채워서 친구 번호랑 매칭
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			
			graph.get(f1).add(f2);
			graph.get(f2).add(f1);
		}
		//=================================================================================
		
		// 친구 관계 파악
		// 1. 친구관계가 제공된 경우
		if(M > 0) {			
			checkFriends();
			// 결과 출력
			System.out.println(result == -1?"Oh no" : result);

		}
		// 2. 친구관계에 대해서 제공되지 않은 경우
		else {
			for(int i = 1; i <= N; i++) {
				result += cost[i];
			}
						
			// 결과 출력
			System.out.println(result > K?"Oh no" : result);
			
		}
		
		//================================================================================
		

	}

	private static void checkFriends() {
		
		// 1번부터 dfs
		// 나온 친부비의 최소값을 결과에 더함
		for(int i = 1; i <= N; i++) {
			//지난적 없는 친구정점이면 최솟값을 더하고 
			//친구의 친구는 친구비가 필요없으니 true로 체크
			if(!visit[i]) {
				dfs(i, cost[i]);
				result += cost[i];
			}
			
			if(result > K) {
				result = -1;
				return;				
			}
		}
		
	}

	// 다 찾아봐야함 마지막 노드가 가장 작은 비용을 가지는 경우가 존재하기 때문
	private static void dfs(int i, int f_cost) {
		//다시 탐색하는 경우를 제외하기 위한 처리
		visit[i] = true;
		
		for(int f_no : graph.get(i)) {
			//현재 정점이 이미 친구인 정점이라면 pass
			if(!visit[f_no]) {
				//들고 온 비용이 내가 갈 정점의 비용보다 작다면
				f_cost = Math.min(f_cost, cost[i]);
				dfs(f_no, f_cost);
				cost[i] = Math.min(cost[f_no], f_cost);
			}
		}
				
	}

	
}