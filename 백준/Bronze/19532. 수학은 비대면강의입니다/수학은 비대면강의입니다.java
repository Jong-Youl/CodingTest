import java.util.Scanner;

// 수학은 비대면강의입니다.
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int min = -999;
		int max = 999;
		
		int x = 0;
		int y = 0;
		
		//식 1번 ax + by = c
		int a = sc.nextInt();// 받는 수
		int b = sc.nextInt();
		int c = sc.nextInt();
		//식 2번 dx + ey = f 
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		
		for(int i=min; i<=max; i++) {
			for(int j=min; j<=max; j++) {
				if((a*i+b*j == c) && (d*i+e*j == f)) {
					x = i;
					y = j;
					break;
				} 
			}
		}
		System.out.println(x+" " +y);
	}
}
