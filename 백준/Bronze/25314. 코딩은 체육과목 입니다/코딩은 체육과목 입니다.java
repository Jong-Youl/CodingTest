import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		for(int i = 0; i<N/4; i++) {
			sb.append("long ");
		}
		sb.append("int");
		System.out.println(sb);
	}
}