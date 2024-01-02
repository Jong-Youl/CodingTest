import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static class Node implements Comparable<Node> {
		int time, pos;

		public Node(int time, int pos) {
			this.time = time;
			this.pos = pos;
		}

		@Override
		public int compareTo(Node o) {
			return time - o.time;
		}

	}

	public static int N, K;
	public static int[] arr = new int[200_001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수빈이의 위치 N, 동생의 위치 K
		N = sc.nextInt();
		K = sc.nextInt();

		// 최대값으로 모두 채우기
		Arrays.fill(arr, Integer.MAX_VALUE);
		// 곱하기 이용 안하면 가장 빠른건 하나씩 더하기 or 빼기
		arr[K] = Math.abs(N - K);
		find();
		System.out.println(arr[K]);
	}

	private static void find() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		int t = 0;
		// 시작지점 넣기
		pq.add(new Node(0, N));
		// bfs같은 너낌 현재 시간이 K까지 가는데 걸리는 시간보다 적을때만 돌아감
		while (!pq.isEmpty() && pq.peek().time < arr[K]) {
			Node tmp = pq.poll();
			
			t = tmp.time;
			// 현재 위치가 K라면
			if (tmp.pos == K) {
				arr[K] = tmp.time;
				return;
			}

			// K보다 뒤에 위치한 경우
			if (tmp.pos < K) {
				// 배수 입력 껍데기
				int dummy = tmp.pos;
				arr[dummy] = tmp.time;
				// 임의의 좌표가 범위를 넘기 전까지
				while (dummy < K) {
					// 순간이동!
					dummy *= 2;
					// 순간이동한 좌표를 가장 빨리 도착한거라면 체크
					if (dummy < 200_001 && arr[dummy] > t) {
						arr[dummy] = t;
						pq.add(new Node(t, dummy));
					}
					// 순간이동한 좌표를 더 빨리 도착할 수 있다면 탈출
					else break;
				}

				// 앞으로 가는 시간이 최소시간보다 빠르다면?
				if (arr[tmp.pos + 1] > t + 1) {
					arr[tmp.pos + 1] = t + 1;
					pq.add(new Node(t + 1, tmp.pos + 1));
				}
				// 아니면 갈필요 없음
			}

			// 뒤로 가는 시간이 최소시간보다 빠르다면?
			if (tmp.pos > 0 && arr[tmp.pos - 1] > t + 1) {
				arr[tmp.pos - 1] = t + 1;
				pq.add(new Node(t + 1, tmp.pos - 1));
			}

		}
	}
}