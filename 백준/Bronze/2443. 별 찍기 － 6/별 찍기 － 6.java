import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        int N = sc.nextInt();
        
        for(int i=1; i<=N;i++){//빈칸 출력 0부터4까지
        	for(int j=0; j<i-1; j++){//i=1일때 출력 x
        		System.out.print(" ");
        		}
        	for(int j=2*(N-i)+1; j>0 ;j--){//처음엔 2n-1개 마지막엔 1개
        		System.out.print("*");
        		}
        System.out.println();
        }
	}
}