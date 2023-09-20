import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static StringTokenizer st;
	public static int [] p;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			p = new int [N+1];
			
			for(int i = 0; i <= N; i++) {
				p[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int cmd = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(cmd == 0) {//둘이 합친다.
					Union(x, y);
				}
				else {
					if(find_set(x) == find_set(y)) {//둘이 같으면
						sb.append('1');
					}
					else
						sb.append('0');
				}
			}
			sb.append("\n");
//			System.out.println(Arrays.toString(p));
		}
		System.out.println(sb);
	}

	private static int find_set(int x) {
		if(x == p[x])return p[x];
		
		p[x] = find_set(p[x]);
		
		return p[x];
	}

	private static void Union(int x, int y) {//둘이 합침
		int px = find_set(x);
		int py = find_set(y);
		
		if(px == py) return;
		
		p[px] = py;
		
	}
}