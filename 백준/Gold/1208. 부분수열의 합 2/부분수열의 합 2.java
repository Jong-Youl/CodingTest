import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static long target, total;
	public static int [] arr;
	public static boolean [] visit;
	public static Map<Long, Long> left, right;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		total = 0;
		arr = new int [N];
		visit = new boolean [N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// key : sum, value : count;
		left = new HashMap<>();
		right = new HashMap<>();

		//depth, sumation
		getLeft(0, 0);
		getRight((N/2), 0);

		for (long key : left.keySet()) {
			long rightTarget = target - key;
			if (right.containsKey(rightTarget)) {
				total += left.get(key) * right.get(rightTarget);
				if(rightTarget == 0 && key == 0) total--;
			}
		}

		System.out.println(total);
	}

	private static void getLeft(int depth, long sum) {
		if(depth == N/2) {
			//map 안에 해당 key가 존재할 경우 ++;
			//없으면 생성
			if(left.containsKey(sum)) {
				left.put(sum, left.get(sum) + 1);
				}
			else left.put(sum, 1L);

			return;
		}
		
		getLeft(depth + 1, sum);
		getLeft(depth + 1, sum + arr[depth]);
	}

	private static void getRight(int depth, long sum) {
		if(depth == N) {
			//map 안에 해당 key가 존재할 경우 ++;
			//없으면 생성
			if(right.containsKey(sum)) {
				right.put(sum, right.get(sum) + 1);
			}
			else right.put(sum, 1L);

			return;
		}
		getRight(depth + 1, sum);
		getRight(depth + 1, sum + arr[depth]);
	}

}