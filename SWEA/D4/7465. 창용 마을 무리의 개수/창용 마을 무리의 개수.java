import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static StringTokenizer st;
	public static int[] p;
	public static Set<Integer> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			set = new HashSet<>();
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int res = 0;
			
			p = new int [N+1];
			
			//make_set
			for(int i = 1; i <= N; i++) {
				p[i] = i;
			}
			//정보 입력
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				//관계되면 하나의 set으로 정리
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				union(x, y);
			}
			for(int i = 1; i <= N; i++) {
				set.add(p[i]);
			}
			
			res = set.size();
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
	private static int find_set(int x) {
		if(p[x] == x) return x;
		
		p[x] = find_set(p[x]);
		
		return p[x];
	}
	
	private static void union(int x, int y) {//정렬 조건
		int px = find_set(x);
		int py = find_set(y);
		
		if(px == py) return;
		
		int max = Math.max(px, py);
		int min = Math.min(px, py);
		//다르면 작은걸로 바꾸자
		
		for(int i = 0 ; i < p.length; i++) {
			if(p[i] == max)
				p[i] = min;
		}		
	}
}