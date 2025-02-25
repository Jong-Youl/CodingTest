import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		
		int T = sc.nextInt();
		p:for(int i = 0; i < T; i++) {
			String curr = sc.next();
			int st = 0;
			int end = curr.length() - 1;
			if(check(curr, st, end)) {
				result.append("YES").append("\n");
			}
			else 
				result.append("NO").append("\n");				
		}
		
		System.out.println(result);
	}

	private static boolean check(String str, int st, int end) {
		if(st == end) 
			return true;
		
		int mid = (st + end) / 2;
		for(int i = st; i < mid; i++) {
			if(str.charAt(i) == str.charAt(end - i))
				return false;
		}
		
		return check(str, st, mid - 1) && check(str, mid + 1, end);
	}
}