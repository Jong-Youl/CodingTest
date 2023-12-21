import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {	
	static char cave[][];
	static int R, C;
	static boolean visit[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		cave = new char[R][C];
		for (int i = 0; i < R; i++) {
			String a = br.readLine();
			for (int j = 0; j < C; j++) {
				cave[i][j] = a.charAt(j);
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int removePoint = Integer.parseInt(st.nextToken());
			removeMi(removePoint, i);
			visit = new boolean[R][C];
			mineralMove();
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(cave[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void removeMi(int row, int cnt) {
		row = R - row;
		
		// 좌우를 반복하면서 제거 하기 때문에 홀수, 짝수를 이용해서 제거.
		if (cnt % 2 == 0) { 
			for (int i = 0; i < C; i++) {
				if (cave[row][i] == 'x') {
					cave[row][i] = '.';
					break; // 하나만 제거하고 막대기가 사라지기 때문에 바로 break;
				}
			}
		} else {
			for (int i = C - 1; i >= 0; i--) {
				if (cave[row][i] == 'x') {
					cave[row][i] = '.';
					break; // 하나만 제거하고 막대기가 사라지기 때문에 바로 break;
				}
			}
		}
	}
	
	static void mineralMove() {
		Queue<Node> q = new LinkedList<>();
		
		for (int j = 0; j < C; j++) { // 땅과 붙어있는 미네랄 bfs 탐색
			if (cave[R - 1][j] =='x' && !visit[R - 1][j]) {
				q.add(new Node(R - 1, j));
				visit[R - 1][j] = true;
			}
			
			while(!q.isEmpty()) {
				Node node = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int newX = node.x + dx[i];
					int newY = node.y + dy[i];
					
					if (isRange(newX, newY) && cave[newX][newY] == 'x' && !visit[newX][newY]) {
						// 동굴의 범위 안이고, 미네랄이고, 방문하지 않았을 경우.
						q.add(new Node(newX, newY));
						visit[newX][newY] = true;
					}
				}
			} // 여기까지 끝나면 땅과 붙어있는 미네랄들이 모두 정리됨.
		}
		
		// 공중에 떠있는 미네랄 찾기
		// 두 개 이상의 클러스터가 동시에 떨어지는 경우가 없어서 가능한 코드.
		ArrayList<Node> airMi = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (cave[i][j] == 'x' && !visit[i][j]) {
					airMi.add(new Node(i, j));
					cave[i][j] = '.';
					visit[i][j] = true;
					// 공중에 떠 있는 미네랄들을 모두 넣어줌.
					// 이동할 것이기 떄문에 .로 바꿔둠.
				}
			}
		}
		
		// 공중에 떠있는 미네랄이 있다면 ~
		if (!airMi.isEmpty()) {
			boolean isStop = false;
			
			while (!isStop) {
				for (int i = 0; i < airMi.size(); i++) {
					int nextX = airMi.get(i).x + 1;
					if (nextX >= R || cave[nextX][airMi.get(i).y] =='x') {
						isStop = true;
						break;
					}
				} // 전체 미네랄이 아래로 한칸 내려갈 수 있는지 확인.
				
				if(!isStop) {
					for (Node node : airMi) {
						node.x++;
						// 내려갈 수 있다면 전체 미네랄을 한칸 내린 좌표를 다시 입력해줌.
					}
				}
			}
			
			// 최대로 내린 미네랄들을 다시 동굴에 입력 해줌.
			for (int i = 0; i < airMi.size(); i++) {
				cave[airMi.get(i).x][airMi.get(i).y] = 'x';
			}
		}
	}
	
	static boolean isRange(int x, int y) {
		if (x < 0 || x >= R || y < 0 || y >= C) {
			return false;
		}
		
		return true;
	}
}

class Node {
	int x;
	int y;
	
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}