import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> arr = new ArrayList<Integer>();
		
		//배열 입력
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr);
		
		for(int i=0; i<N; i++) {
			bw.write(arr.get(i) + " ");
		}
		bw.flush();
		bw.close();
	}
}
