import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static int cnt = 1;
	public static boolean [] visit;
	public static int [] graph;//그래프 순서 저장 배열
	public static ArrayList<ArrayList<Integer>> temp = new ArrayList<>();;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1];//방문 확인 배열
		graph = new int [N+1];//
		
		for(int i=0; i<=N; i++) {
			temp.add(new ArrayList<>());//N의 개수만큼 내부에 리스트를 추가
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			//방향이 없기 때문에 쌍방으로 저장
			temp.get(u).add(v);
			temp.get(v).add(u);
		}
		dfs(R);
		
		// 노드 구성 완료
		for(int i = 1; i<=N; i++) {//시작점
			System.out.println(graph[i]);
		}
	}
	public static void dfs(int R) {//현재 노드 (현재의 시작점을 받음)
		visit[R] = true;//방문처리
		graph[R] = cnt++;//순번 저장?
		
		Collections.sort(temp.get(R), Collections.reverseOrder());	//R번째 리스트를 내림차순 정렬
		
		for(Integer value : temp.get(R)) {
			if(!visit[value]) {
				dfs(value);
			}
		}
		return;
	}
}