import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        //bfs
        boolean [] visit = new boolean [n + 1];
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> dummy;
        
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        
        for(int [] vertex : edge) {
            graph.get(vertex[0]).add(vertex[1]);
            graph.get(vertex[1]).add(vertex[0]);
        }
        
        //1번 노드부터 시작 전부 담음
        visit[1] = true;
        q.add(1);
        
        while(true) {
            dummy = new ArrayList<>();    
            
            while(!q.isEmpty()) {
                int curr = q.poll();

                for(int num : graph.get(curr)){
                    if(!visit[num]) {
                        visit[num] = true;
                        dummy.add(num);
                    }
                }
            }
            
            if(dummy.isEmpty()) break;
            for(int num : dummy)
                q.add(num);
            
            answer = dummy.size();         
        }
        
        return answer;
    }
}