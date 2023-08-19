import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = 9; //난쟁이들의 수
		int real_N = 7;//진짜 난쟁이는 7명
		
		int [] qute = new int [N];//난쟁이는 귀여워 
		int [] real = new int [real_N];//난쟁이는 귀여워
		
		for(int i = 0; i < N; i++) {
			qute[i] = sc.nextInt();
		}
		Arrays.sort(qute);
				
	p:	for(int a = 0; a < N-6; a++) {
			real[0] = qute[a];
			for(int b= a+1; b < N-5; b++) {
				real[1] = qute[b];
				for(int c = b+1; c < N-4; c++) {
					real[2] = qute[c];
					for(int d = c+1; d < N-3; d++) {
						real[3] = qute[d];
						for(int e = d+1; e < N-2; e++) {
							real[4] = qute[e];
							for(int f = e+1; f < N-1; f++) {
								real[5] = qute[f];
								for(int g=f+1; g < N; g++) {
									real[6] = qute[g];
									int sum = qute[a] + qute[b]+ qute[c] + qute[d] + qute[e] + qute[f]+ qute[g];
									if(sum == 100) {
										break p;
									}
								}
							}
						}
					}
				}
			}
		}
		
		for(int i=0; i<real_N; i++) {
			System.out.println(real[i]);
		}
	}
}