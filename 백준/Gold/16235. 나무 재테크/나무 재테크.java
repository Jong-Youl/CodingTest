import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Tree implements Comparable<Tree>{
		int r, c, age;

		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return age - o.age;
		}

		@Override
		public String toString() {
			return "Tree [r=" + r + ", c=" + c + ", age=" + age + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
		int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int [][] map = new int [N+1][N+1];
		int [][] add = new int [N+1][N+1];

		for(int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= N; c++) {
				map[r][c] = 5;
				add[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Tree> tree_q = new LinkedList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			tree_q.add(new Tree(r, c, age));
		}
		
		//리스트로 명시적 형변환해주면 소트 가능
		Collections.sort((List<Tree>)tree_q);
		
		int cnt = 1;
		while(cnt <= K) {
			List<Tree> die = new ArrayList<>();
			
			int tmp_rep = tree_q.size();
			//봄
			for(int i = 0; i < tmp_rep; i++) {
				Tree tmp = tree_q.poll();
				if(map[tmp.r][tmp.c] >= tmp.age) {//양분이 남아 있으면 
					map[tmp.r][tmp.c] -= tmp.age;
					tree_q.add(new Tree(tmp.r, tmp.c, tmp.age + 1));
				}
				else die.add(tmp);
			}
			
			//여름
			//죽었던 애들 양분으로 변함
			for(Tree tree : die) {
				map[tree.r][tree.c] += tree.age/2;
			}
			
			//가을
			//5년치면 번식
			int rep = tree_q.size();
			List<Tree> tmp_lst = new ArrayList<>();
			
			while (rep > 0) {
				Tree tmp = tree_q.poll();
				//나이가 5의 배수이면 번식
				if(tmp.age % 5 == 0) {
					for(int i = 0; i < 8; i++) {
						int r = tmp.r + dr[i];
						int c = tmp.c + dc[i];
						if(0 < r && 0 < c && r <= N && c <= N) tree_q.add(new Tree(r, c, 1));
					}
				}
				tmp_lst.add(tmp);
				rep--;
			}
			
			for(Tree tree : tmp_lst) {
				tree_q.add(tree);
			}
			
			//겨울
			for(int r = 1 ; r <= N; r++) {
				for(int c =1 ; c <= N; c++) {
					map[r][c] += add[r][c];
				}
			}
			cnt++;
		}
		
		System.out.println(tree_q.size());
	}
	
}