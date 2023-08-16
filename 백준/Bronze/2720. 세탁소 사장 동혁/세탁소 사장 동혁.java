import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int money = Integer.parseInt(br.readLine());
			int q = 0;
			int d = 0;
			int n = 0;
			int p = 0;
			if (money >= 25) {
				q = money / 25;
				money %= 25;
			}
			if (money >= 10) {
				d = money / 10;
				money %= 10;
			}
			if (money >= 5) {
				n = money / 5;
				money %= 5;
			}
			if (money >= 1) {
				p = money / 1;
			}

			System.out.printf(q + " " + d + " " + n + " " + p + "\n");
		}

	}
}