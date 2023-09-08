import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//둘의 최소 차이를 구하는 거니까 결국 N/2임(누가 어느 정당이든 노상관)

public class Main {

	public static int min, N, total;
	public static int[][] graph;
	public static boolean[] A;
	public static int[] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		cnt = new int[N + 1];
		A = new boolean [N+1];
		graph = new int[N + 1][N + 1];
		min = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
			total += cnt[i];
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int edge_cnt = Integer.parseInt(st.nextToken());
			// 연결 정보를 배열에 담기
			for (int j = 0; j < edge_cnt; j++) {
				graph[i][Integer.parseInt(st.nextToken())]++;
			}
		}
		// 남은 것들이 이어지는지도 확인(어떻게?)

		choose_A(1);
		System.out.println(min == Integer.MAX_VALUE? -1:min);
	}

	public static void choose_A(int idx) {
		// 하나씩 늘려가면서 연결 마을 생성
		if (idx == N + 1) {// 하나 빼고 다 이었으면 굳이 돌 필요 없음
			if (check()) {
				int sum = 0;
				
				for(int i =1; i <= N; i++) {
					if(A[i])
						sum += cnt[i];
				}
				int value = total - sum;
				min = Math.min(min, Math.abs(value - sum));
			}
			return;
		}

		// 뽑을 때 마다 체크하고 보내셈
		A[idx] = true;
		choose_A(idx + 1);

		A[idx] = false;
		choose_A(idx + 1);
	}

	public static boolean check() {
		boolean[] visit = new boolean[N + 1];

		int start_a = -1;
		for (int i = 1; i <= N; i++) {
			if (A[i]) {
				start_a = i;
				break;
			}
		}
		int start_b = -1;
		for (int i = 1; i <= N; i++) {
			if (!A[i]) {
				start_b = i;
				break;
			}
		}

		
		// 둘 중에 하나는 안뽑음
		if (start_a == -1 || start_b == -1)
			return false;

		Queue<Integer> q = new LinkedList<>();

		// a끼리 연결 되었는지 확인
		q.add(start_a);
		visit[start_a] = true;
		while (!q.isEmpty()) {

			int tmp = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if (graph[tmp][i] == 0)
					continue;

				int v = i;
				// 이미 확인했거나 A 지역구가 아닌경우
				if (visit[v] || !A[v])
					continue;

				// A 지역구이면서 아직 체크 안했으면
				visit[v] = true;
				q.add(v);
			}
		}

		q.add(start_b);
		visit[start_b] = true;
		while (!q.isEmpty()) {

			int tmp = q.poll();
			for (int i = 1; i <= N; i++) {
				if (graph[tmp][i] == 0)
					continue;

				int v = i;
				// 이미 확인했거나 B 지역구가 아닌경우
				if (visit[v] || A[v])
					continue;

				// B 지역구이면서 아직 체크 안했으면
				visit[v] = true;
				q.add(v);
			}
		}
		
		// 한 곳이라도 연결되지 않았다면
		for (int i = 1; i <= N; i++) {
			if (!visit[i])
				return false;
		}

		return true;
	}
}