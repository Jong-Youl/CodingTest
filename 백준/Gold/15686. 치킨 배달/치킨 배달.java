import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node{
	int r, c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
}

public class Main {
	
	static int N;//도시 크기
	static int M;//치킨집 수
	static List<Node> chicken = new ArrayList<>();
	static int[][] live;//살아남은 치킨
	static List<Node> person = new ArrayList<>();
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());// 지도 크기
		M = Integer.parseInt(st.nextToken());// 살아 남은 치킨 집 

		int [][] arr = new int[N][N];// 치킨 정보
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				
				if (arr[r][c] == 2) {
					chicken.add(new Node(r, c));
				}
				else if (arr[r][c] == 1) {
					person.add(new Node(r, c));
				}
				
			}
		}
		
		live = new int [M][2];
		chicken_distance(0, 0);
		System.out.println(min);
	}
	
	public static void chicken_sum() {
		int res = 0;
		
		for(int i=0; i<person.size(); i++) {//고객마다의
			int p_min = Integer.MAX_VALUE;//최소거리
			for(int j=0; j<M; j++) {
				p_min = Math.min(p_min, Math.abs(person.get(i).r - live[j][0]) + Math.abs(person.get(i).c - live[j][1]));
			}
			res += p_min;
		}
		min = Math.min(min, res);
		return;
	}

	public static void chicken_distance(int index, int depth) {
		//탈출
		if(depth == M) {//치킨집 조합의 길이가 M개가 됬다면
			chicken_sum();
			return;
		}
		
		for(int i=index; i<chicken.size();i++) {//치킨집 조합 뽑기
				live[depth][0] = chicken.get(i).r;
				live[depth][1] = chicken.get(i).c;
				chicken_distance(i+1, depth+1);
			}
		}
	}