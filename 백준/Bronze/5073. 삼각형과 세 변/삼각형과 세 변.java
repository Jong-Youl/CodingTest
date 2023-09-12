import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[3];
		String res = "";

		while (sc.hasNext()) {
			for (int i = 0; i < 3; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);
			
			if (arr[0] == 0) {
				break;
			}
			if (arr[0] + arr[1] <= arr[2]) {
				res = "Invalid";
			} else if (arr[0] == arr[1] && arr[1] == arr[2]) {
				res = "Equilateral";
			} else if (arr[0] == arr[1] || arr[1] == arr[2]) {
				res = "Isosceles";
			} else
				res = "Scalene";

			System.out.println(res);
		}
		sc.close();
	}
}