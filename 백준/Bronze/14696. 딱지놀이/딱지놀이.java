import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int N = sc.nextInt();
	
	for(int rep = 0; rep<N; rep++) {//게임 횟수
		//플레이어 1
		int n1 = sc.nextInt();
		int [] p1 = new int [5]; 
		for(int i = 0; i<n1;i++) {
			int idx = sc.nextInt();
			p1[idx]++;
		}
		//플레이어 2
		int n2 = sc.nextInt();
		int [] p2 = new int [5]; 
		for(int i = 0; i<n2;i++) {
			int idx = sc.nextInt();
			p2[idx]++;
		}
		
		if(p1[4] != p2[4]) {//별 개수가 다를 떄
			if(p1[4] > p2[4]) {//p1의 별 개수가 더 클 떄
				System.out.println("A");
			}
			else {
				System.out.println("B");
			}
		}
		else if(p1[3] != p2[3]) {//동그라미 개수가 다를 떄
			if(p1[3] > p2[3]) {//p1의 동그라미 개수가 더 클 떄
				System.out.println("A");
			}
			else {
				System.out.println("B");
			}
		}
		else if(p1[2] != p2[2]) {//네모 개수가 다를 떄
			if(p1[2] > p2[2]) {//p1의 네모 개수가 더 클 떄
				System.out.println("A");
			}
			else {
				System.out.println("B");
			}
		}
		else if(p1[1] != p2[1]) {//세모 개수가 다를 떄
			if(p1[1] > p2[1]) {//p1의 네모 개수가 더 클 떄
				System.out.println("A");
			}
			else {
				System.out.println("B");
			}
		}
		else {
			System.out.println("D");
		}
	}
}
}