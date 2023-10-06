import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st2.nextToken());
		int c = Integer.parseInt(st2.nextToken());
		int temp = Integer.parseInt(st2.nextToken());
		
		//현재의 위치 x, y
		int x = r;
		int y = c;
		
		boolean what = false; 
		// temp가 0이면 위방향을 바라보고 있는 것이고
		// 1이면 오른쪽, 2면 아래방향, 3이면 왼쪽을 바라보고 있는 것이다.

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st3.nextToken());
			}
		}

//		System.out.println(Arrays.deepToString(arr));
		int cnt = 0;
		b: while (true) {
			if (arr[r][c] == 0) {
				arr[r][c] = 2;
				cnt++;
			}

			// 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우(벽(1)이거나 이미 청소된 경우(2))
			if (arr[r + 1][c] != 0 && arr[r - 1][c] != 0 && arr[r][c + 1] != 0 && arr[r][c - 1] != 0) {
				 if (r + 1 < N && r - 1 >= 0 && c + 1 < M && c - 1 >= 0) {
					if (temp == 0) {
						if (arr[r + 1][c] != 1) {
							x = x + 1;
						} else {
							System.out.println(cnt);
							return;
						}

					} else if (temp == 1) {
						if (arr[r][c - 1] != 1) {
							y = y - 1;
						} else {
							System.out.println(cnt);
							return;
						}
					} else if (temp == 2) {
						if (arr[r - 1][c] != 1) {
							x = x - 1;
						} else {
							System.out.println(cnt);
							return;
						}
					} else if (temp == 3) {
						if (arr[r][c + 1] != 1) {
							y = y + 1;
						} else {
							System.out.println(cnt);
							return;
						}
					}
				}
				
				r = x;
				c = y; 
			}

			// 주변 4칸 중 청소되지 않는 빈 칸이 한 칸이라도 있는 경우(한 곳이라도 0이 있는 경우)
//			else if(arr[r+1][c]==0||arr[r-1][c]==0||arr[r][c+1]==0||arr[r][c-1]==0) {
//			} else if를 안 써도 가능?

			else {
				
				while(!what) {
				
				
				if(temp>0) {
					temp = temp-1;
				}
				else {
					temp = temp+3; 
				}
				if(temp==0&&arr[r-1][c]==0) {
					x = x-1; 
					arr[r-1][c]=2;
					cnt++;
				}
				else if(temp==1&&arr[r][c+1]==0) {
					y = y+1;
					arr[r][c+1]=2;
					cnt++;
				}
				else if(temp==2&&arr[r+1][c]==0) {
					x = x+1;
					arr[r+1][c]=2;
					cnt++;
				}
				else if(temp==3&&arr[r][c-1]==0) {
					y = y-1; 
					arr[r][c-1]=2;
					cnt++;
				}
				
				r = x;
				c = y; 
				
				if (arr[r + 1][c] != 0 && arr[r - 1][c] != 0 && arr[r][c + 1] != 0 && arr[r][c - 1] != 0){
					continue b; 
				}
				
				}
				
				
				
				
				
				
//				if(temp==0&&arr[r+1][c]==1) {
//					System.out.println(cnt);
//					return;
//				}
//				else if(temp==1&&arr[r][c-1]==1) {
//					System.out.println(cnt);
//					return;
//				}
//				else if(temp==2&&arr[r-1][c]==1) {
//					System.out.println(cnt);
//					return;
//				}
//				else if(temp==3&&arr[r][c+1]==1) {
//					System.out.println(cnt);
//					return;
//				}
				
				

			}
			

		}

	}
}
