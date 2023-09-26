import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {

			String str = br.readLine();

			String[] arr2 = str.split(" ");

			int[] arr3 = new int[arr2.length];

			for (int i = 0; i < arr3.length; i++) {

				arr3[i] = Integer.parseInt(arr2[i]);
			}

			int k = arr3[0] + arr3[1];

//			System.out.println(k);

			bw.write(k+"\n");
			
		}
		bw.flush();
		bw.close();
	}

}
