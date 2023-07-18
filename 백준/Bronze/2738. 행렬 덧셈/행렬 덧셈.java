import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		        
		int N = sc.nextInt();
		int M = sc.nextInt();
		        
		int[][] A = new int [N][M];
		int[][] B = new int [N][M];
		int[][] sum = new int [N][M];
		        
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				A[i][j] = sc.nextInt();
		    }
		}//A배열 생성
		        
		        
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				B[i][j] = sc.nextInt();
		    }
		}//B배열 생성
		        
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				sum[i][j] = A[i][j] + B[i][j];
		        	System.out.print(sum[i][j] + " ");
		    }
		    System.out.println();
		}//sum배열 생성 및 출력
	}
}