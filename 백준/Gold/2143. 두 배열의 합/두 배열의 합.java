import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long result = 0;
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			B[i] = B[i - 1] + Integer.parseInt(st.nextToken());
		}

		long[] sumA = getSummationArray(N, A);
		long[] sumB = getSummationArray(M, B);

		Arrays.sort(sumA);
		Arrays.sort(sumB);

		int left = 0;
		int right = sumB.length - 1;

		while (left < sumA.length && right > -1) {
			long startA = sumA[left], startB = sumB[right];
			long sum = startA + startB;
			if (sum == T) {
				long cntA = 0, cntB = 0;
				while (left < sumA.length && startA == sumA[left]) {
					left++;
					cntA++;
				}

				while (right > -1 && startB == sumB[right]) {
					right--;
					cntB++;
				}
				result += cntA * cntB;
			}
			if (sum > T) {
				right--;
			} else if (sum < T) {
				left++;
			}
		}
		System.out.println(result);
	}

	public static long[] getSummationArray(int size, int[] arr) {
		long[] result = new long[size * (size + 1) / 2];

		int idx = 0;
		for (int i = 1; i <= size; i++) {
			for (int j = i; j <= size; j++) {
				int tmp = arr[j];
				if (i > 1)
					tmp -= arr[i - 1];
				result[idx++] = tmp;
			}
		}

		return result;
	}
}