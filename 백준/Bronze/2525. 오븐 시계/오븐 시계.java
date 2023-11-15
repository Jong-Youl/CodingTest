import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if(B + C >= 60) {
            A += ((B+C)/60);
			B = ((B+C)%60);
		}else {
			B += C;
		}
		
		if(A >= 24) {
			A = A%24;
		}
		System.out.println(A+" "+B);
	}
}
