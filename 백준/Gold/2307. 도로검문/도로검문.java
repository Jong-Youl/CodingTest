import java.io.*;
import java.util.*;

public class Main {
    static int INF = 987654321;
    static int N, M;
    static List<List<Node>> graph = new ArrayList<>();
    static List<int[]> pathEdges = new ArrayList<>();

    static class Node implements Comparable<Node> {
        int v, e;

        Node(int v, int e) {
            this.v = v;
            this.e = e;
        }

        @Override
        public int compareTo(Node n) {
            return this.e - n.e;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) 
            graph.add(new ArrayList<>());

        int[][] edges = new int[M][3];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new int[]{u, v, cost};
            graph.get(u).add(new Node(v, cost));
            graph.get(v).add(new Node(u, cost));
        }


        int[] prev = new int[N + 1];
        int[] dist = dijkstra(1, prev);
        int originalTime = dist[N];

        getTracePath(N, prev);

        int max = 0;
        for (int[] edge : pathEdges) {
            removeEdge(edge[0], edge[1]);
            int[] newDist = dijkstra(1, new int[N + 1]);
            restoreEdge(edge[0], edge[1], edge[2]);

            if (newDist[N] == INF) {
                System.out.println(-1);
                return;
            }

            max = Math.max(max, newDist[N] - originalTime);
        }

        System.out.println(max);
    }

    private static int[] dijkstra(int start, int[] prev) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.e > dist[curr.v]) continue;

            for (Node next : graph.get(curr.v)) {
                if (dist[next.v] > dist[curr.v] + next.e) {
                    dist[next.v] = dist[curr.v] + next.e;
                    prev[next.v] = curr.v;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }

    private static void getTracePath(int node, int[] prev) {
        while (node != 1) {
            int parent = prev[node];
            pathEdges.add(new int[]{parent, node, findEdgeWeight(parent, node)});
            node = parent;
        }
    }

    private static void removeEdge(int u, int v) {
        graph.get(u).removeIf(n -> n.v == v);
        graph.get(v).removeIf(n -> n.v == u);
    }

    private static void restoreEdge(int u, int v, int cost) {
        graph.get(u).add(new Node(v, cost));
        graph.get(v).add(new Node(u, cost));
    }

    private static int findEdgeWeight(int u, int v) {
        for (Node node : graph.get(u)) {
            if (node.v == v) return node.e;
        }
        return -1;
    }
}