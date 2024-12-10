import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프 생성
        List<List<Integer>> graph = buildGraph(n, edge);

        // BFS 초기화
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;

        int answer = 0;

        // BFS 실행
        while (!q.isEmpty()) {
            int levelSize = q.size(); // 현재 레벨의 노드 수
            answer = levelSize;

            for (int i = 0; i < levelSize; i++) {
                int curr = q.poll();

                for (int neighbor : graph.get(curr)) {
                    if (!visit[neighbor]) {
                        visit[neighbor] = true;
                        q.add(neighbor);
                    }
                }
            }
        }

        return answer;
    }

    private List<List<Integer>> buildGraph(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] vertex : edge) {
            graph.get(vertex[0]).add(vertex[1]);
            graph.get(vertex[1]).add(vertex[0]);
        }
        return graph;
    }
}