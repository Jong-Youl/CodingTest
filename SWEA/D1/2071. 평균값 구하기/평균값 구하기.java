import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			float sum = 0;
			for (int j=0; j<10;j++) {
				int n = sc.nextInt();
				sum += n;
			}
		int avg = Math.round(sum/10);
		System.out.println("#"+tc+" "+avg);
		}
	}
}
