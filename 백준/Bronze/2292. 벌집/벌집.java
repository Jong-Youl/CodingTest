import java.util.Scanner;

public class Main {
	static int [] beee; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int minus = 1;//빼줄 수
		int cnt = 1;//방 이동 횟수
		
		while(N>0) {
			N -= minus;
			if(N > 0) {
				minus = 6 * cnt; 
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}