import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> tree;
       
        // 정보 입력
        for(int i = 0; i < wires.length; i++) {
            // tree 생성
            tree = new ArrayList<>();        
            for(int j = 0; j <= n; j++)
                tree.add(new ArrayList<>());
            
            for(int j = 0; j < wires.length; j++) {
                // 하나씩 제외하면서 시행
                if(i == j) continue;
                tree.get(wires[j][0]).add(wires[j][1]);
                tree.get(wires[j][1]).add(wires[j][0]);
            }
            
            // 1부터 탐색하고 남은 정점들은 못간거임
            boolean [] visit = new boolean [n + 1];
            //dfs
            visit[1] = true;
            dfs(1, tree, visit);
            int checked = 0;
            for(int j = 1; j <= n; j++)
                if(visit[j]) checked++;
            
            answer = Math.min(answer, Math.abs(n - 2 * checked));
        }
        
        return answer;
    }
    
    public void dfs (int start, List<List<Integer>> tree, boolean [] visit) {
        for(int i = 0; i < tree.get(start).size(); i++) {
            int currNode = tree.get(start).get(i);
            
            if(!visit[currNode]) {
                visit[currNode] = true;
                dfs(currNode, tree, visit);
            }
        }
    }
}