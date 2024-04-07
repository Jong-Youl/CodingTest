import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int [] road = new int [100_001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		int N  = Integer.parseInt(st.nextToken());
		int K  = Integer.parseInt(st.nextToken());

		//둘의 위치가 같을 때
		if(N == K) {
			System.out.println(0);
		}
		//다를 때
		else {
			bfs(N, K);
		}
	}

	private static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		road[n] = 1;

		while(!q.isEmpty()) {
			int tmp = q.poll();

			for(int i = 0; i < 3; i++) {
				int next;

				if(i == 0) {
					next = tmp + 1;
				}
				else if(i == 1) {
					next = tmp - 1;
				}
				else {
					next = tmp * 2;
				}
				// 도착하면 끝
				if(next == k) {
					System.out.println(road[tmp]);
					return;
				}
				// 인덱스 안벗어나고 값이 없으면
				if (next >= 0 && next < road.length && road[next] == 0) {
					q.add(next);
					road[next] = road[tmp] + 1;
				}
			}
		}
	}
}