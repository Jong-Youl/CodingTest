import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean [] check_x = new boolean [1001];
		boolean [] check_y = new boolean [1001];
		
		
		for(int i = 0; i < 3; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			check_x[x] = !check_x[x];
			check_y[y] = !check_y[y];

		}		
		
		int tmp_x = -1;
		int tmp_y = -1;
		
		for(int i = 0; i<=1000; i++) {
			if(check_x[i])
				tmp_x = i;
			if(check_y[i])
				tmp_y = i;
		}
		
		System.out.println(tmp_x+" "+tmp_y);
		sc.close();
	}
}