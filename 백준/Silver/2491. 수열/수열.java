import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int [N];
		
		int res = 0;//결과 배열
		int cnt_1 = 1;//오름차순 중간 길이 측정
		int cnt_2 = 1;//내림차순 중간 길이 측정
		//배열 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//완료
		for(int i=1; i<N; i++) {
			if(arr[i] > arr[i-1]) {//현재 값이 이전 값보다 크면
				cnt_1++;//오름차순 카운트 증가
				cnt_2 =1;//내림차순은 초기화
				res = Math.max(res, cnt_1);//둘 중에 큰게 결과
			}
			else if(arr[i] < arr[i-1]) {
				cnt_1 = 1;//오름차순 카운트 초기화
				cnt_2++;//내림차순 카운트 증가
				res = Math.max(res, cnt_2);//둘 중에 큰게 결과
			}
			else {//그 전과 값이 같다면
				cnt_1++;//오름차순 카운트 증가
				cnt_2++;//내림차순 카운트 증가
				int tmp = Math.max(cnt_1, cnt_2);//두 카운트 중에 큰게 결과
				res = Math.max(res, tmp);//그거랑 최종이랑 비교
			}
		}
		
		if(N == 1) {//케이스가 한개면
			res = 1;
		}
		System.out.println(res);
	}
}