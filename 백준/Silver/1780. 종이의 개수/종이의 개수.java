import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int [][] arr;
	public static int [] cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int [N][N];
		cnt = new int [3];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		judge(0, 0, N);
		
		for(int i =0; i<cnt.length;i++) {
			System.out.println(cnt[i]);
		}
	}
	
	public static void judge(int r, int c, int n) {
		boolean check = false;
		
	p:	for(int i =r; i<r+n; i++) {
			for(int j =c; j<c+n; j++) {
				if(arr[i][j] != arr[r][c]) {//시작점이랑 다르면
					check =true;
					break p;
				}
			}
		}
		
		if(n == 3 && check) {
			for(int i =r; i<r+n; i++) {
				for(int j =c; j<c+n; j++) {
					if(arr[i][j] == 1)
						cnt[2]++;
					else if (arr[i][j] == 0)	
						cnt[1]++;
					else
						cnt[0]++;
				}
			}
			
			return;
		}		
		
		if(check) {//다른게 나왔으면
			
			int n1 = n/3;
			//1행 3개
			judge(r, c, n1);
			judge(r, c+n1, n1);
			judge(r, c+2*n1, n1);
			//2행 3개
			judge(r+n1, c, n1);
			judge(r+n1, c+n1, n1);
			judge(r+n1, c+2*n1, n1);
			//3행 3개
			judge(r+2*n1, c, n1);
			judge(r+2*n1, c+n1, n1);
			judge(r+2*n1, c+2*n1, n1);
		}
		
		else {//전부 같았다면
			if(arr[r][c] == 1)
				cnt[2]++;
			else if(arr[r][c] == 0)
				cnt[1]++;
			else
				cnt[0]++;
		}
	}
}