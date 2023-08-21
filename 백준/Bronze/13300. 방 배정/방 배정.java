import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//인원수
		int K = sc.nextInt();//최대 수용 인원
		int res = 0; //필요 방 개수
		
		int [] girl = new int [7];
		int [] boy = new int [7];
		
		for(int i=0; i<N;i++) {
			int s = sc.nextInt();
			int grade = sc.nextInt();
			
			if(s == 0) {
				girl[grade]++;	
			}
			else {
				boy[grade]++;	
			}
		}
		
		for(int i = 1; i<=6; i++) {
			if(girl[i] % K == 0) {//방에 딱맞게 나누어지면
				if(girl[i] != 0) {
					res += girl[i]/K;
				}
			}
			else if(girl[i] % K != 0) {
				res += (girl[i]/K + 1) ;
			}
		}
		
		for(int i = 1; i<=6; i++) {
			if(boy[i] % K == 0) {//방에 딱맞게 나누어지면
				if(girl[i] != 0) {
					res += boy[i]/K;
				}
			}
			else if(boy[i] % K != 0) {
				res += (boy[i]/K + 1) ;
			}
		}
		System.out.println(res);
	}
}