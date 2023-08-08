import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int N;// 배열의 크기
	public static int [][] arr;// 배열 선언
	public static String s = " ";
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int r=0;r<N;r++) {
			String s = br.readLine();
			for(int c=0;c<N;c++) {
				arr[r][c] = s.charAt(c)-'0';
			}
		}
		
		Qtree(0,0,N);
		System.out.println(sb);	
	}
	
	public static boolean check(int r, int c, int N) {
		for(int i=0; i<N;i++) {
			for(int j=0; j<N;j++) {
				if(arr[r+i][c+j] != arr[r][c])//배열의 요소가 하나라도 다르다면
					return false;
			}
		}
		return true;// 모두 같다면
	}
	
	public static void Qtree(int r, int c, int N){
		//확인
		if(check(r,c,N)) {// 체크한 부분의 요소가 같다면
			//숫자 추가
				sb.append(arr[r][c]);
				return;
		}
		//다르면 괄호 추가
		sb.append("(");
		
		int Num = N/2;
		
		//한번에 끝나지 않을 경우 괄호를 열어주고 4등분한 메소드에서 각각 s를 반환
		Qtree(r,c,Num);
		Qtree(r, c+Num, Num);
		Qtree(r+Num, c, Num);
		Qtree(r+Num, c+Num, Num);
		
		sb.append(")");
	}
}
