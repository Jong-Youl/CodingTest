import java.util.*;

class Solution {
    
    class Node implements Comparable<Node>{
        int node, edge;
        
        Node(int node, int edge) {
            this.node = node;
            this.edge = edge;
        }
        
        @Override
        public int compareTo(Node n) {
            return n.edge - this.edge;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int inf = 987654321;
        
        // K 시간 이하로 배달이 가능한 마을에서만 주문을 받을 수 있음
        // 1번 출발
        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<List<Node>> graph = new ArrayList<>();
        int [] cost = new int [N + 1];
        
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            cost[i] = inf;
        }
        
        for(int [] info : road) {
            graph.get(info[0]).add(new Node(info[1], info[2]));
            graph.get(info[1]).add(new Node(info[0], info[2]));
        }
        
        cost[1] = 0;
        
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (cost[curr.node] < curr.edge)
                continue;
            
            for (Node next : graph.get(curr.node)) {
                if (cost[next.node] > cost[curr.node] + next.edge) {
                    cost[next.node] = cost[curr.node] + next.edge;
                    pq.add(new Node(next.node, cost[next.node]));
                }
            }
        }
        
        for(int i = 1; i <= N; i++) {
            if(cost[i] <= K)
                answer++;
        }

        return answer;
    }
}

//        System.out.println("Hello Java");