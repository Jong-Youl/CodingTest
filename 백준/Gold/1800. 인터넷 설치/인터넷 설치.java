import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node>{
        int v, cost;

         public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
         }

        @Override
        public int compareTo(Node o) {
             return cost - o.cost;
        }
    }
    //P = 총 연결, N = 사람 수, K = 공짜 케이블선의 개수
    public static int P, N, K, result;
    final static int inf = 987654321;
    //최소비용, 방문처리 배열
    public static int [] cost;

    public static List<List<Node>> graph = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = -1;

        // 그래프 구현
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        //간선정보
        for(int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            //양방향 연결
            graph.get(v1).add(new Node(v2, cost));
            graph.get(v2).add(new Node(v1, cost));
        }
        
        //최대 비용 100만원이라서
        search(0, inf);

        System.out.println(result);
    }

    private static void init() {
    	//최대값으로 채움
        cost = new int [N+1];
        Arrays.fill(cost, inf);
        cost[1] = 0;
    	
    }
    
    private static void search(int start, int end) {
		
    	while(start <= end) {
    		int mid = (start + end) / 2;
    		if(dijkstra(mid)) {
    			result = mid;
    			end = mid - 1;
    		}
    		else {	
    			start = mid + 1;
    		}
    	}
		
	}

	private static boolean dijkstra(int mid) {
        //거리 배열 초기화
		init();
        
		PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작 지점은 항상 1
        pq.add(new Node(1, 0));
       
        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            
            //현재 정점에서 갈 수 있는 모든 정점 순회
            for(Node n : graph.get(tmp.v)) {
            	// 해당 숫자가 설정값보다 작으면 카운트 안함
            	int c = n.cost <= mid ? 0 : 1;
            	
            	if(cost[n.v] > tmp.cost + c) {
            		cost[n.v] = tmp.cost + c;
            		
            		pq.add(new Node(n.v, tmp.cost + c));
            	}
            }
        }
        
		return cost[N] <= K;
    }

}