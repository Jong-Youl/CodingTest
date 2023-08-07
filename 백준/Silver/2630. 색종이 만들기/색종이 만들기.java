import java.util.Scanner;

public class Main {
	
	static int white = 0;
	static int blue = 0;
	static int [][]arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		arr = new int[N][N];
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		partition(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);

	}
	
	public static void partition(int r, int c, int N) {
		//화이트 블루 확인
		if(check(r,c,N)) {//체크가 트루면
			//컬러가 다 같으면 하나씩 더해줌
			if(arr[r][c] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}
		
		int Num = N/2;
		
		//재귀 4개를 동시에
		partition(r,c,Num);
		partition(r+Num, c, Num);
		partition(r, c+Num, Num);
		partition(r+Num, c+Num, Num);	
	}
	
	public static boolean check(int r, int c, int N) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if (arr[r+i][c+j] != arr[r][c]) {
					return false;
				}
			}
		}
		
		return true;	
	}

}
