import java.io.*;
import java.util.*;


class Score implements Comparable<Score>{
	int p, i;
	
	Score(int p, int i) {
		this.p = p;
		this.i = i;
	}
	
	@Override
	public int compareTo(Score o) {
		return this.p - o.p;
	}	
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int tc = sc.nextInt();
		int N, cnt;
		List<Score> list;
		
		for (int t = 0; t < tc; t++) {
			N = sc.nextInt();
			cnt = N;
			list = new ArrayList<>();
			for (int i = 0; i < N; i++)
				list.add(new Score(sc.nextInt(), sc.nextInt()));
			
			Collections.sort(list);
			int minRank = list.get(0).i;
			
			// 서류 2등부터
			for (int i = 1; i < N; i++) {
				// 위에 나보다 면접을 잘 본 사람이 있으면 탈락
				if(minRank < list.get(i).i)
					cnt--;
				else
					minRank = list.get(i).i;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);		
	}
}