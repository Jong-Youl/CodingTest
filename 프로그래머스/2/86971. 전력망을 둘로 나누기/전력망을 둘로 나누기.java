import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> tree = new ArrayList<>();

        // tree 생성
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            tree.get(wire[0]).add(wire[1]);
            tree.get(wire[1]).add(wire[0]);
        }

        // 각 전선을 끊고 비교
        for (int[] wire : wires) {
            int a = wire[0], b = wire[1];

            // 연결 끊기
            tree.get(a).remove((Integer) b);
            tree.get(b).remove((Integer) a);

            // 트리의 크기 계산
            boolean[] visit = new boolean[n + 1];
            int subtreeSize = dfs(1, tree, visit);

            // 차이 계산
            answer = Math.min(answer, Math.abs(n - 2 * subtreeSize));

            // 연결 복구
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        return answer;
    }

    public int dfs(int node, List<List<Integer>> tree, boolean[] visit) {
        visit[node] = true;
        int size = 1;

        for (int neighbor : tree.get(node)) {
            if (!visit[neighbor]) {
                size += dfs(neighbor, tree, visit);
            }
        }

        return size;
    }
}
