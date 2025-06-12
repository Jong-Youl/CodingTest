import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        List<List<Integer>> graph = new ArrayList<>();
        boolean [] visit = new boolean [n];
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        //어처피 양방향으로 나와서 따로 할 필요없음
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1 && i != j)
                    graph.get(i).add(j);
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;
            answer++;
            dfs(i, graph, visit);
        }
    
        return answer;
    }

    public void dfs (int node, List<List<Integer>> graph, boolean [] visit) {
        if(visit[node]) 
            return;

        visit[node] = true;
        for(int i = 0; i < graph.get(node).size(); i++) {
            int next = graph.get(node).get(i);
            dfs(next, graph, visit); 
        }
    }
}