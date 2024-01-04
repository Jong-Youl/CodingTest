import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// 각각 트럭의 수, 다리의 길이, 다리의 최대 하중
	public static int N, W, L, time, b_weight;
	public static StringTokenizer st;
	public static Queue<Integer> truck, bridge;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		time = 0;
		b_weight = 0;

		truck = new LinkedList<>();
		bridge = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < W; i++) {
			bridge.add(0);
		}

		crossing();

		System.out.println(time);

	}

	private static void crossing() {
		
		while (!bridge.isEmpty()) {
			time++;
			b_weight -= bridge.poll();

			if (!truck.isEmpty()) {
				if (truck.peek() + b_weight <= L) {
					b_weight += truck.peek();
					bridge.add(truck.poll());
				}
				else {
					bridge.add(0);
				}
			}
			
		}
	}
}