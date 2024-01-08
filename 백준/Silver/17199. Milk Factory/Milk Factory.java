import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, result;
	public static int [] degree;
	public static List<List<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		degree = new int [N + 1];
		result = -1;
		
		//각 정점 생성
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		//간선 구현	
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			//단방향
			graph.get(v).add(u);
		}
		
		for(int i = 1; i <= N; i++) {
			dfs(i);			
		}
		
		for(int i = 1; i <= N; i++) {
			if(degree[i] == N-1) {
				result = i;
				break;
			};			
		}
		
		System.out.println(result);
	}

	private static void dfs(int start) {
		
		for(int i = 0; i < graph.get(start).size(); i++) {
			int tmp = graph.get(start).get(i);
			
			degree[tmp]++;
			dfs(tmp);
		}
		
	}
}