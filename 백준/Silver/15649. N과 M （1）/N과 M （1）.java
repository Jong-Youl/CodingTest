import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int []arr = new int[9];
	static boolean[]visited = new boolean[9] ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		backtracking(0);
		
	}
	
	public static void backtracking(int k) {
		if(k==M) {//탈출
			for(int i=0;i<M;i++) {
				System.out.print(arr[i]+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N;i++) {//숫자는 결국 1부터 들어간다.
			if(!visited[i]) {//불리안 배열의 값이 false라면 탐색 안했음
				arr[k] = i;//k = 0부터 시작해서 첫번째 값 할당
				visited[i] = true;//해당 i 사용 완료
				backtracking(k+1);//사용한 i 빼고 나머지에 대해서 재귀
				visited[i] = false;//재귀 다돌고 다시 원위치
			}
		}
	}
}
