import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class blank {
		int r, c;

		public blank(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int cnt = 0;
	static int N = 9;
	static int[][] map = new int[N][N];
	static List<blank> lst = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 스도쿠 받기
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 0) lst.add(new blank(r, c));
			}
		}

		fill(0);
		
	}
	private static void fill(int depth) {
		if(depth == lst.size()) {
			print();
			cnt++;
			return;
		}
		
		int r = lst.get(depth).r;
		int c = lst.get(depth).c;
		
		for(int i = 1; i <= N; i++) {
			
			if(checking(r, c, i)) {
				map[r][c] = i;
				fill(depth+1);
				if (cnt >= 1) return;
				map[r][c] = 0;
			} 
		}
		
	}
	private static boolean checking(int r, int c, int num) {
		//row, col검사
		if(!row_col_check(r, c, num)) return false;

		//정사각형 검사
		if(!square_check( (r/3) * 3 , (c/3) * 3 , num)) return false;
		
		return true;
	}
	private static boolean row_col_check(int r, int c, int num) {
		
		for(int i = 0; i < N; i++) {
			if(map[r][i] == num) return false;//가로줄에 value와 같은 값이 있다면 false
            if(map[i][c] == num) return false;//세로줄에 value와 같은 값이 있다면 false
		}
		return true;
	}
	
	private static boolean square_check(int i, int j, int num) {
		
		for(int r = i; r < i+3; r++) {
			for(int c = j; c < j+3; c++) {
				if(map[r][c] == num) return false;
			}
		}
		return true;
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sb.append(map[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}