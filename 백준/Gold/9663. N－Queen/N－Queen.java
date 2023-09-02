import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int N, res;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		//체스판 배열
		int [][] board = new int [N][N];
		//퀸을 놓을 수 있는지 없는지에 대한 배열
		//false면 가능 true면 불가능
		queen(0, board);
		
		System.out.println(res);
	}

	public static void queen(int row, int [][] board) {
		if(row == N) {//모든 행 퀸 배치 완료시
			res++;
			return;
		}
		
		//기본 동작
		//첫 행부터 돌면서 시작해서 마지막 행까지 돌아감
		//놓는 곳과 같은 행 같은 열에는 더 이상의 퀸이 들어올 수 없음
		for(int c = 0; c<N; c++) {
			if(board[row][c] == 0) {//들어갈 수 있다면 들어가
				check(row, c, board);//다음 행부터 못들어가는 곳 체크
				queen(row+1, board);//다음행 탐색
				uncheck(row, c, board);//아까 체크했던 곳 돌려줘
			}
			//방문 못하면 다음 열 탐색
		}
	}
	
	public static void check(int r, int c, int [][] board) {
		//같은 열 대각선 처리
		//중요한 점은 위에 행과 본인 행은 처리 안해줘도 됨 어처피 못옴
		
		for(int nr = r+1; nr<N; nr++) {//행 처리
			if(board[nr][c] == 0) {	
				board[nr][c] = r+1;
			}
		}
		//대각선 체크
		int lc = c;//왼쪽 아래로 내려갈 대각선
		int rc = c;//오른쪽 아래로 내려갈 대각선
		int nr = r;
		
		while(nr < N-1) {//마지막 행까지 처리
			nr++;//아래 행 체크
			if(lc > 0 && board[nr][lc-1] == 0) {//왼쪽으로 갈 수 있으면
				board[nr][--lc] = r+1;
			}
			else 
				lc--;
			
			if(rc < N-1 && board[nr][rc+1] == 0) {//오른쪽으로 갈 수 있으면
				board[nr][++rc] = r+1;
			}
			else
				rc++;
		}
		
	}
	public static void uncheck(int r, int c, int [][] board) {
		//같은 열 대각선 처리
		//중요한 점은 위에 행과 본인 행은 처리 안해줘도 됨 어처피 못옴
		for(int nr = r+1; nr<N; nr++) {//행 처리
				if(board[nr][c] == r+1) {
					board[nr][c] = 0;
				}
		}
		//대각선 체크
		int lc = c;//왼쪽 아래로 내려갈 대각선
		int rc = c;//오른쪽 아래로 내려갈 대각선
		int nr = r;
		while(nr < N-1) {//마지막 행까지 처리
			nr++;//아래 행 체크
			if(lc > 0 && board[nr][lc-1] == r+1) {//왼쪽으로 갈 수 있으면
				board[nr][--lc] = 0;
			}
			else
				lc--;
			if(rc < N-1 && board[nr][rc+1] == r+1) {//오른쪽으로 갈 수 있으면
				board[nr][++rc] = 0;
			}
			else
				rc++;
		}
		
	}
	
}