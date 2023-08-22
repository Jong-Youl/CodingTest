import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] foward;
		int [] backward;
			
		int min_idx = Integer.MAX_VALUE;
		int max_idx = Integer.MIN_VALUE;
		
		int N = sc.nextInt();//기둥 개수
		int [] arr = new int [1001];//최대 1000
		
		for(int i =0 ; i<N; i++) {
			int L = sc.nextInt();//x좌표
			int H = sc.nextInt();//높이
			
			arr[L] = H;
			
			if(min_idx>L) {
				min_idx = L;
			}
			if(max_idx<L) {
				max_idx = L;
			}
		}
		
		foward = new int [max_idx - min_idx +1];
		backward = new int[max_idx - min_idx +1];
		
		foward[0] = arr[min_idx];
		backward[backward.length-1] = arr[max_idx];
		
		for(int i = 1; i<max_idx - min_idx + 1; i++) {
			if(foward[i-1] < arr[i+min_idx]){
				foward[i] = arr[i+min_idx];
			}
			else {
				foward[i] = foward[i-1];
			}
		}
		
		for(int i = max_idx; i>min_idx; i--) {
			if(backward[i - min_idx] < arr[i-1]){//끝 값이랑 끝값 비교했을 때 작으면
				backward[i - min_idx -1] = arr[i-1];
			}
			else {
				backward[i - min_idx -1] = backward[i - min_idx];
			}
		}
		int res = 0;
		
		for(int i=0; i<foward.length; i++) {
			int tmp = Math.min(foward[i], backward[i]); 
			res += tmp;
		}
		System.out.println(res);
	}
}