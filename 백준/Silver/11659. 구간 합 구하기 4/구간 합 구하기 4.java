import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int [] arr = new int [N+1];
        int [] sum = new int [N+1];
        
        for(int i = 1; i <= N; i++) {
        	arr[i] = sc.nextInt();
        }
        
        for(int i = 1; i <= N; i++) {
        	sum[i] = sum[i-1] + arr[i];
        }
        
        for(int i = 0; i<M; i++) {
        	int idx1 = sc.nextInt();
        	int idx2 = sc.nextInt();
        	
        	System.out.println(sum[idx2] - sum[idx1-1]);
        }
    }
}