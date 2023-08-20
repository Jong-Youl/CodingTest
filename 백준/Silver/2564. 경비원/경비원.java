import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int w = Integer.parseInt(st.nextToken());//가로
	int h = Integer.parseInt(st.nextToken());//세로 연구소
	int total = 2*(w+h);
	int res = 0;//동근이형 최소 움직임
	
	int N = Integer.parseInt(br.readLine());//호출 횟수
	
	int [] dist = new int [N+1]; //복 0 이 시작일때 거리 북 동 남 서
	
	for(int i = 0; i<=N; i++) {
		st = new StringTokenizer(br.readLine());
		
		int dir = Integer.parseInt(st.nextToken());
		int pos = Integer.parseInt(st.nextToken());
		
		switch(dir){
		case 1://북쪽일 때
			dist[i] = pos;
			break;
		case 2://남쪽일 때
			dist[i] = (w - pos) + w + h;//가로 더하기 세로 더하기 가로 - 위치
			break;
		case 3://서쪽일 때
			dist[i] = (h - pos) + 2*w + h;//가로 더하기 세로 더하기 가로 - 위치
			break;
		case 4://동쪽일 때
			dist[i] = pos + w;//가로 더하기 위치
			break;
		}
	}
	
	int dong_pos = dist[N];
	
	for(int i=0; i<N; i++) {
		int tmp = Math.abs(dong_pos - dist[i]);//동근이형과의 거리
		
		res += Math.min(tmp, total - tmp);
	}
	
	System.out.println(res);
		
}
}