import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int v, e;

    Node(int v, int e) {
        this.v = v;
        this.e = e;
    }

    @Override
    public int compareTo(Node o) {
        return this.e - o.e;
    }
}

public class Main {
    static int N, M, X;
    static List<List<Node>> graph, reverseGraph;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // init
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        //그래프 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, edge));   // 원래 방향
            reverseGraph.get(end).add(new Node(start, edge)); // 역방향 그래프
        }

        int[] go = dijkstra(graph, X);
        int[] back = dijkstra(reverseGraph, X);

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, go[i] + back[i]);
        }

        System.out.println(maxTime);
    }

    static int[] dijkstra(List<List<Node>> graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.e > dist[curr.v]) continue; // 기존 최단 거리보다 크면 무시

            for (Node next : graph.get(curr.v)) {
                if (dist[curr.v] + next.e < dist[next.v]) {
                    dist[next.v] = dist[curr.v] + next.e;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        return dist;
    }
}