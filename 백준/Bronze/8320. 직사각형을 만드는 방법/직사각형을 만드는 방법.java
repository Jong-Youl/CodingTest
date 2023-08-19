import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	int n = sc.nextInt();// 정사각형 개수
	
	int res = 0;
	for(int i = 1; i<=n; i++){
		int cnt = 0;
		
		for(int j = 1; j<=i; j++) {//끝까지 도셈
			if(i%j ==0) {
				cnt++;
			}
		}
		
		if(cnt % 2 == 1) {
			cnt++;
		}
		
		res += cnt/2;
	}
	System.out.println(res);
	}
}