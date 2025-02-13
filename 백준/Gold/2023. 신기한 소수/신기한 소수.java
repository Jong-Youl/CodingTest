import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static List<Integer> result = new ArrayList<>();
	private static int [] startSet = {2, 3, 5, 7};
	private static int [] normalSet = {1, 3, 5, 7, 9};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 0; i < startSet.length; i++) {
			dfs(1, N, new StringBuilder().append(startSet[i]));			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : result)
			sb.append(i).append("\n");
		
		System.out.println(sb);
	}
	
	private static void dfs(int depth, int maxDepth, StringBuilder sb) {
		if(depth == maxDepth) {
			result.add(Integer.parseInt(sb.toString()));
			return;
		}
		
		for(int i = 0; i < normalSet.length; i++) {
			sb.append(normalSet[i]);
			int curr = Integer.parseInt(sb.toString());

			if(isPrime(curr))
				dfs(depth + 1, maxDepth, sb);
			
			sb.deleteCharAt(sb.length() - 1);
		}
		
	}
	
	private static boolean isPrime(int N) {
		if(N < 2|| N % 2 == 0)
			return false;
		
		if(N == 2)
			return true;
		
		for(int i = 3; i * i <= N; i += 2) {
			if(N % i == 0)
				return false;
		}
		
		return true;
	}
}