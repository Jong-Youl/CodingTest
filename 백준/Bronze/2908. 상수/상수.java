import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		String res1 = "";
		String res2 = "";
		
		for(int i=str2.length()-1; i>=0;i--) {
			res1 += String.format("%s", str1.charAt(i));
		}
		for(int i=str2.length()-1; i>=0;i--) {
			res2 += String.format("%s", str2.charAt(i));
		}
		
		int res = Math.max(Integer.parseInt(res1),Integer.parseInt(res2));
		
		System.out.println(res);
		}
	}