import java.util.Scanner;

// 분해합
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();// 받는 수

		for (int i = 0; i < n; i++) {// 생성자가 그 수보다는 무조건 작음
			int res = i;// 생성자 i로 만들어질 분해합
			String str = Integer.toString(i);
			int copy = i;// for문 내부에서 돌려져 없어질 값
			for (int j = str.length() - 1; j >= 0; j--) {
				res += copy / (int) Math.pow(10, j);
				copy %= (int) Math.pow(10, j);
			}
			if (res == n) {
				System.out.println(i);
				break;
			}
			if (res != n && i==n-1) {
				System.out.println(0);
				break;
			}
		}
	}
}