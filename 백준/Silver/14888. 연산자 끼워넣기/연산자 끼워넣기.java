import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		//숫자 개수
		N = Integer.parseInt(br.readLine());

		int [] arr = new int [N];
		int [] opt = new int [4];//+-*/순서

		//숫자 정보 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//각각 연산의 갯수
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			opt[i] = Integer.parseInt(st.nextToken());
		}

		comb(arr[0], 1, arr, opt);

		System.out.println(max);
		System.out.println(min);
	}

	private static void comb(int res, int depth, int [] arr, int[] opt) {
		if(depth == N) {
			max = Math.max(res, max);
			min = Math.min(res, min);
			return;
		}

		for(int i = 0; i < 4; i++) {
			if(opt[i] > 0) {
				opt[i]--;
				int tmp = arr[depth];

				if(i == 0) {
					comb(res + tmp, depth + 1, arr, opt);
				}
				else if (i == 1) {
					comb(res - tmp, depth + 1, arr, opt);
				}
				else if (i == 2) {
					comb(res * tmp, depth + 1, arr, opt);
				}
				else {
					comb(res / tmp, depth + 1, arr, opt);
				}
				opt[i]++;
			}
		}
	}
}