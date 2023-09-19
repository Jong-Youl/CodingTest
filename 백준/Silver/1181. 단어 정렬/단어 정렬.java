import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1 길이가 짧은 것 부터
//2 길이가 같으면 사전 순으로
class Dict implements Comparable<Dict>{
	int len;
	String str;
	
	public Dict(String str) {
		this.str = str;
		this.len = str.length();
	}

	@Override
	public int compareTo(Dict o) {
		// TODO Auto-generated method stub
		if(len == o.len) {
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) != o.str.charAt(i))
					return str.charAt(i) - o.str.charAt(i);
			}
			
		}
		
		return len - o.len;
	}
	
}


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Dict [] dict = new Dict [N];
		
		for(int i = 0; i < N; i++) {
			dict[i] = new Dict(br.readLine());
		}
		
		Arrays.sort(dict);
		
		for(int i = 0; i < N; i++) {
			if(i == 0)
				sb.append(dict[i].str).append("\n");
			else if(!dict[i].str.equals(dict[i-1].str))
				sb.append(dict[i].str).append("\n");
		}
		
		System.out.println(sb);
	}
}