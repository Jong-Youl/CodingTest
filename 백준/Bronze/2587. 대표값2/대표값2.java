import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//버블 소트 연습
public class Main {

	public static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		num = new int[5];
		int total = 0;
		int mean = 0;
		int median = 0;

		for (int i = 0; i < 5; i++) {
			num[i] = Integer.parseInt(br.readLine());
			total += num[i];
		}

		quik_sort(num, 0, 5);
		mean = total / 5;
		median = num[2];

		sb.append(mean).append("\n").append(median);

		System.out.println(sb);

	}

	public static void quik_sort(int[] arr, int l, int h) {// DESC 버전
		if (l < h) {
			int j = partition(arr, l, h);

			quik_sort(arr, l, j);
			quik_sort(arr, j + 1, h);
		}
	}

	public static int partition(int[] arr, int l, int h) {
		int pivot = arr[l];
		int i = l;
		int j = h;
		
		while(i < j) {
			do i++;
			while(i < 5 && arr[i] <= pivot);
			
			do j--;
			while(arr[j] > pivot);
			
			if(i < j)
				swap(arr, i, j);
			
		}
		
		swap(arr, l, j);
		return j;
	}
	
	public static void swap(int [] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}