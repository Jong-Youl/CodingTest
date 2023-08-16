import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int [] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 받을 숫자
		arr = new int [N+1]; //
		arr[1] = 0;
		System.out.println(make_one(N));
	}
	
	public static int make_one(int n) {// 1로 만드는 메소드
		if(n==1) {
			return arr[1];//1은 연산할 필요 X
		}
		else{
			for(int i=2; i<=n; i++) {
				if(i%3 == 0 && i%2 == 0) {//3과 2의 공배수일 때
					arr[i] = Math.min(arr[i/3] + 1, arr[i/2] + 1);
					arr[i] = Math.min(arr[i], arr[i-1]+1);
				}
				else if(i%3 == 0) {//3의 배수일 때
					arr[i] = Math.min(arr[i-1] +1, arr[i/3] + 1);
				}
				else if(i%2 == 0) {//2의 배수일 때
					arr[i] = Math.min(arr[i-1] +1, arr[i/2] + 1);//3으로 나누는게 연산이 가장 짧은데 1크니까 걍 1빼고 3나눔
				}
				else {//아니면 하나씩 빼면서 연산 횟수 줄이기
					arr[i] = arr[i-1] + 1;
				}
			}
		}
		return arr[n];
	}
}