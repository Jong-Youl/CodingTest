import java.util.*;

class Solution {
    public class Node implements Comparable <Node>{
        int v, e;
        
        Node(int v, int e) {
            this.v = v;
            this.e = e;
        }
        
        @Override
        public int compareTo(Node n) {
            return n.e - this.e;
        }
        
    }
    
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        /*
            각 마을에는 1부터 N까지의 번호가 각각 하나씩 부여되어 있습니다.
            각 마을은 양방향으로 통행
            1번 마을에 있는 음식점에서 각 마을로 음식 배달
            각 마을로부터 음식 주문을 받으려고 하는데, N개의 마을 중에서 K 시간 이하로 배달이 가능한 마을에서만 주문
            다음은 N = 5, K = 3
        */
        
        // init 
        int [] dist = new int [N + 1];
        int inf = 987654321;
        Arrays.fill(dist, inf);
        dist[1] = 0;
        // 인덱스 = 출발 정점, 요소 = 도착 정점
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());
        
        for(int [] info : road) {
            int v1 = info[0];
            int v2 = info[1];
            int e = info[2];
            
            graph.get(v1).add(new Node(v2, e));
            graph.get(v2).add(new Node(v1, e));
        }
        
        // 다익스트라로 함 조지기
        dejikstra(graph, dist);
        
        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K)
                answer++;
        }

        return answer;
    }
    
    public void dejikstra(List<List<Node>> graph, int [] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            // 1에서 출발해서 도착하는 정점과 거기까지 가기 위한 시간
            Node curr = pq.poll();

            for(int i = 0; i < graph.get(curr.v).size(); i++) {
                Node next = graph.get(curr.v).get(i);
                
                if(dist[next.v] > dist[curr.v] + next.e) {
                    dist[next.v] = dist[curr.v] + next.e;
                    pq.add(next);
                }
            }
        }
    }
    
}