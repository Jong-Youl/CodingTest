import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long total = 0;

		//시험장의 개수
		int N = Integer.parseInt(br.readLine());
		int [] people = new int [N];

		//각 시험장의 응시자 수
		st =  new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			people[i] = Integer.parseInt(st.nextToken());
		}

		//B와 C
		st =  new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		//각 시험장별 필요 감독관 찾기
		for(int pNum : people) {
			pNum -= B;
			total++;
			//연산 줄이기
			if(pNum > 0){
				total += pNum/C;
				if(pNum % C != 0)
					total++;
			}
		}
		//출력
		System.out.println(total);
	}
}