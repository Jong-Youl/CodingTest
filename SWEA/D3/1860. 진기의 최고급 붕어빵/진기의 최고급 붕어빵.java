import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
	 p:	for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 손님 명수
			int M = sc.nextInt();// 붕어빵 한번 만드는데 걸리는 시간
			int K = sc.nextInt();// 현재 붕어빵 갯수
			int b_cnt = 0;
			
			int [] time = new int [N];
			int idx =0;
			
			for(int i=0; i<N; i++) {//배열 입력
				time[i] = sc.nextInt();
			}
			
			Arrays.sort(time);
			
			for(int i=0; i<11112; i++) {// i는 realtime
				if(i % M == 0 && i != 0) {//i를 M으로 나누면 0이 나올 때 붕어빵을 만들 수 있는 시간임
					b_cnt += K;//붕어빵 만들어서 갯수 늘어남
				}
				boolean cant = false;
				
				while(time[idx] == i) {//실제 시간과 손님이 도착하는 시간이 같거나 늦을 때
					if(b_cnt == 0) {//붕어빵이 없다면
						System.out.println("#"+tc+" Impossible");//불가능
						continue p;
					}
					else {
						idx++;//다음 것도 같은지 확인
						b_cnt--;
						if(idx == N) {
							System.out.println("#"+tc+" Possible");
							cant =true;
							break;
						}
					}
				}
				if(cant)break;
			}
		}
	}
}
