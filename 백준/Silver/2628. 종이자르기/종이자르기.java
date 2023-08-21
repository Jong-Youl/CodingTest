import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> x = new ArrayList<Integer>();
		List<Integer> y = new ArrayList<Integer>();
		
		int width = sc.nextInt();
		int height = sc.nextInt();
		
		x.add(width);
		y.add(height);
		
		int n = sc.nextInt();
		
		for(int i = 0; i<n;i++) {
			int dir = sc.nextInt();
			int k = sc.nextInt();
			
			if(dir == 0) {//가로로 자르면 세로가 달라짐
				y.add(k);
			}
			else {//가로로 자르면 세로가 달라짐
				x.add(k);
			}
		}
		
		int [] arr_x = new int [x.size()+1];
		int [] arr_y = new int [y.size()+1];
		
		for(int i = 1; i<=x.size(); i++) {
			arr_x[i] = x.get(i-1);
		}
		for(int i = 1; i<=y.size(); i++) {
			arr_y[i] = y.get(i-1);
		}
		
		Arrays.sort(arr_x);
		Arrays.sort(arr_y);

		int max_x = 0;
		int max_y = 0;
		
		for(int i = 0; i<arr_x.length-1; i++) {
			int tmp = arr_x[i+1] - arr_x[i];
			max_x = Math.max(max_x, tmp);
		}
		for(int i = 0; i<arr_y.length-1; i++) {
			int tmp = arr_y[i+1] - arr_y[i];
			max_y = Math.max(max_y, tmp);
		}
		
		int res = max_x * max_y;
		
		System.out.println(res);
	}
}