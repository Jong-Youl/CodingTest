import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int num = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (arr[i] < num)
				sb.append(arr[i]).append(" ");
		}
		sc.close();
		System.out.print(sb);
	}
}