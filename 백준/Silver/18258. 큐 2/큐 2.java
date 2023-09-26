import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder(); //선언

		String str = sb.toString(); //들어있는 문자열을 변수에 저장 가능 
		
		

		int n = Integer.parseInt(st.nextToken()); 
	
		
		
		Queue<Integer> que = new LinkedList<>();
		
		for (int tc = 1; tc <= n; tc++) {


			String a = br.readLine();

			String[] arr = a.split(" ");

			int f3 = 0;

			if (arr.length == 2) {

				String f1 = arr[0];
				String f2 = arr[1];
				f3 = Integer.parseInt(f2);
			}

			

//			System.out.println(Arrays.toString(arr));
//			System.out.println(arr[0]);

			if (arr[0].equals("push")) {

				que.offer(f3);


			}

			else if (arr[0].equals("pop")) {

				if (que.isEmpty()) {

//					System.out.println(-1);
					sb.append(-1).append("\n");
				}

				else {
					
					sb.append(que.poll()).append("\n");
//					System.out.println(que.poll());
				}

//				System.out.println(que);
			}

			else if (arr[0].equals("size")) {

				sb.append(que.size()).append("\n");
//				System.out.println(que.size());
			}

			else if (arr[0].equals("empty")) {

				if (que.isEmpty()) {

					sb.append(1).append("\n");
//					System.out.println(1);

				}

				else {

					sb.append(0).append("\n");
				}
			}

			else if (arr[0].equals("front")) {

//				System.out.println(que);
				
				if (que.isEmpty()) {

					sb.append(-1).append("\n");

				}

				else {

					sb.append(que.peek()).append("\n");
//					System.out.println(que.peek());
				}

			}

			else if (arr[0].equals("back")) {

				if (que.isEmpty()) {

					sb.append(-1).append("\n");

				}

				else {
					
					sb.append(((LinkedList<Integer>) que).getLast()).append("\n");
//					System.out.println(((LinkedList<Integer>) que).getLast());
					
				}

			}
			
			
			
			
		}
		
		System.out.println(sb);
	}

}
