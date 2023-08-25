import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean [] check;
	static int [][] arr;
	static int N, M, start;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());// 정점의 갯수
		M = Integer.parseInt(st.nextToken());// 간선의 갯수
		start = Integer.parseInt(st.nextToken());// 정점의 번호
		
		arr = new int[N+1][N+1];
		check = new boolean [N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());//시작 정점
			int v2 = Integer.parseInt(st.nextToken());//도착 정점
			
			arr[v1][v2] = arr[v2][v1] = 1;//양방향 그래프이다
		}
		
		dfs(start);
		sb.append("\n");//다음칸으로 출력

		check = new boolean [N+1];
		bfs(start);
		
		System.out.println(sb);
	}
	
	public static void dfs(int i) {
		check[i] = true;
		sb.append(i + " ");
		
		for(int j =0; j <= N; j++) {
			if(arr[i][j] == 1 && !check[j]) {//간선이 존재하면서 방문체크가 되지 않았다면
				dfs(j);
			}
		}
	}
	
	public static void bfs(int i) {
		q.add(i);
		check[i] = true;//방문처리
		
		while(!q.isEmpty()) {
			
			int tmp = q.poll();
			sb.append(tmp + " ");
			
			for(int j = 0; j <= N; j++) {
				if(arr[tmp][j] == 1 && !check[j]) {
					q.add(j);
					check[j] = true;
				}
			}
			
		}
		
		
	}
}