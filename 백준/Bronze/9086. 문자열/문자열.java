import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String str = br.readLine();

			System.out.print(str.charAt(0));
			System.out.print(str.charAt(str.length() - 1) + "\n");
		}
	}
}