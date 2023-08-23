import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int [] dice = new int [6];//주사위;
	public static int [] tmp = new int [6];//현재값
	public static int [] idx = new int [6];//현재 인덱스
	public static int [] res = new int [6];//각 경우의 합
	
	public static int N;
	public static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		idx[0]  = 0;//현재 a의 idx 값
		idx[1]  = 1;//현재 b의 idx 값
		idx[2]  = 2;//현재 c의 idx 값
		idx[3]  = 3;//현재 d의 idx 값
		idx[4]  = 4;//현재 e의 idx 값
		idx[5]  = 5;//현재 f의 idx 값
		
		N = Integer.parseInt(br.readLine());//주사위 갯수
		
		//A, B, C, D, E, F를 먼저 고르는 경우
		for(int i =0; i<N; i++) {
			dice = new int [6];
			
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<6; j++) {//새로운 주사위 정보
				dice[j] = Integer.parseInt(st.nextToken());
			}
			
//			System.out.println(Arrays.toString(dice));
//			System.out.println("idx : " + idx[0]);
//			System.out.println("tmp : " + tmp[0]);
			
			for(int j = 0; j<6; j++) {
				if(tmp[j] == 0) {//j번째 경우의 현재 값이 없을 때
					tmp[j] = dice[idx[j]];
					res(j,j);
				}
				
				else {//현재 값이 있으면 
					for(int k =0; k<6; k++) {
						if(tmp[j] == dice[k]) {//현재 값과 같은 값을 찾는다면 해당 값은 위로 가고 아래 값을 idx로 받아옴
							res(j, k);
							idx[j] = check_idx(k);//방금 위로 본 값을 아래로 보는 값으로 변환
							tmp[j] = dice[idx[j]];//새롭게 아래를 보는 값을 만듦
							break;//찾으면 종료
						}
					}
				}
			}
//			System.out.println("idx : " + idx[0]);
//			System.out.println("tmp : " + tmp[0]);
//			System.out.println("res : " + res[0]);
		
		}
		
		for(int i=0; i<6; i++) {
			max = Math.max(max, res[i]);
		}
		System.out.println(max);
	}
	public static int check_idx(int idx) {//idx를 넣으면 반대편의 idx를 출력해주는 메소드
		if(idx == 0) {//A일 때
			return 5;//F반환
		}
		if(idx == 1) {//A일 때
			return 3;//F반환
		}
		if(idx == 2) {//A일 때
			return 4;//F반환
		}
		if(idx == 3) {//A일 때
			return 1;//F반환
		}
		if(idx == 4) {//A일 때
			return 2;//F반환
		}
		if(idx == 5) {//A일 때
			return 0;//F반환
		}
		return -1;//잘못 입력되면
	}
	
	public static void res(int num, int idx) {//num = 몇 번째 경우인지, idx는 현재 위 혹은 아래를 바라보는 숫자의 인덱스
		if(idx == 0 || idx == 5) {
			int max1 = Math.max(dice[1], dice[2]);
			int max2 = Math.max(dice[3], dice[4]);
 
			res[num] += Math.max(max1, max2);
			return;
		}
		
		if(idx == 1 || idx == 3) {
			int max1 = Math.max(dice[0], dice[2]);
			int max2 = Math.max(dice[5], dice[4]);
 
			res[num] += Math.max(max1, max2); 
			return;
		}
		if(idx == 2 || idx == 4) {
			int max1 = Math.max(dice[1], dice[5]);
			int max2 = Math.max(dice[3], dice[0]);
 
			res[num] += Math.max(max1, max2); 
			return;
		}
		
		return;
	}
}