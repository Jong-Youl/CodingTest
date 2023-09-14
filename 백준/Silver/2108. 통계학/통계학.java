import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int total = 0;
		int max = 0;// 최대 빈도를 찾을 변수
		int cnt = 0;// 최빈값이 여러개일 떄 카운트할 변수

		int mean = 0;
		int median = 0;
		int mode = 0;
		int range = 0;

		int[] count = new int[8001];// -4000부터 4000
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
			count[arr[i] + 4000]++;
		}

		Arrays.sort(arr);

		for (int i = 0; i < 8001; i++) {// 최빈값
			if(count[i] == 0) continue;
			
			if (count[i] == max) {// 같은 경우라면
				cnt++;// 최빈값의 개수 1 증가
				if (cnt == 2) {// 두 번째 수일 때
					mode = i - 4000;// 현재 인덱스를 -범위로 넘겨주고 mode 갱신
				}
			} 
			else if (count[i] > max) {
				// 단순히 클 때
				max = count[i];// 현재 카운트값을 최대 빈도로 갱신
				cnt = 1;// 최빈값의 갯수는 새로 갱신
				mode = i - 4000;// 현재 인덱스를 -범위로 넘겨주고 mode도 갱신
			}
		}

		mean = Math.round((float)total / (float)N);
		median = arr[N / 2];// N은 항상 홀수라서 짝수일 경우 고려x
		range = arr[N - 1] - arr[0];
		
		sb.append(mean).append("\n").append(median).append("\n").append(mode).append("\n").append(range);

		System.out.println(sb);
	}
}