import java.util.Scanner;
 
public class Main {
    static int N=0;
    static int M=0;
	static boolean[]visited = new boolean[9] ;//각 자리수를 돌았는지 확인
	static int[] arr =new int[9];//최대 8이기 떄문에
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        N = sc.nextInt();
        M = sc.nextInt();
        
        backtracking(0);	
    }
	
	public static void backtracking(int k) {
		if(k == M) {
			for(int i =0; i<M; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(!visited[i]){
				arr[k] =i+1;
				visited[i] = true;
				backtracking(k+1);
				for(int j = i+1; j<=N; j++) {
					visited[j] = false;
				}
			}
		}
	}
}