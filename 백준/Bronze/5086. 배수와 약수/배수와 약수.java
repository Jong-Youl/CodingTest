import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			if(A == 0 && B==0) {
				break;
			}
			
			if(B % A == 0) sb.append("factor");
			else if (A % B == 0) sb.append("multiple");
			else sb.append("neither");
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}