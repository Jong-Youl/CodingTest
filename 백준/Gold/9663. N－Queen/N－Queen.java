import java.util.Scanner;

public class Main {
	public static int N;
	public static int cnt;
	public static int [] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		
		Queen(0);
		System.out.println(cnt);
		
	}
	public static boolean check(int c) {
		for(int i=0; i<c;i++) {
			if(arr[c]==arr[i]) {
				return false;
			}
			else if(Math.abs(c-i) == Math.abs(arr[c]-arr[i])) {//대각선에 같은 값이 있다면
				return false;
			}
		}
		return true;
	}
	
	public static void Queen(int r) {
		if(r==N) {//행이 끝까지 돌았으면
			cnt++;
			return;
		}
		//안돌았으면
		for(int c=0;c<N;c++) {
			arr[r] = c;//행에 열값을 넣어주고
			if(check(r)) {//r에 놓을 수 있다면
				Queen(r+1);
			}
		}
	}
}