import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static long [] pado = new long[100+1];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		pado[1] = 1;
		pado[2] = 1;
		pado[3] = 1;
		pado[4] = 2;
		pado[5] = 2;
		for(int rep = 0; rep<T; rep++) {
			long num = Integer.parseInt(br.readLine());
			System.out.println(wave(num));
		}
		
	}
	
	public static long wave(long num) {
		if(pado[(int) num] != 0) {
			return pado[(int) num];
		}
			
		else {
			pado[(int) num] = wave(num-1) + wave(num-5); 
			return pado[(int) num]; 
		}		
	}
}