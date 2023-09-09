import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(max);
		sc.close();
		System.out.print(sb);
	}
}