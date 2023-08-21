import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());// 가로
		int h = Integer.parseInt(st.nextToken());// 세로

		st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());// 개미 x
		int y = Integer.parseInt(st.nextToken());// 개미 y

		long t = Integer.parseInt(br.readLine());// 시간

		x += (int) (t % (2*w));//제자리에서 이동한 횟수 x
		y += (int) (t % (2*h));//제자리에서 이동한 횟수 y
		
		if(x>w) {//범위를 벗어난다면
			x = Math.abs(w*2 - x);
		}
		if(y>h) {//범위를 벗어난다면
			y = Math.abs(h*2 - y);
		}
		
		System.out.println(x + " " + y);
	}
}