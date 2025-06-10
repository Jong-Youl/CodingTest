import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        boolean [][] scoreBoard = new boolean [n + 1][n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        
        for(int [] result : results)
            graph.get(result[0]).add(result[1]);
        
        for(int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1]; // 방문 체크 추가
            List<Integer> next = new ArrayList<>();
            next.add(i);
            visited[i] = true;

            for(int j = 0; j < next.size(); j++) {
                int curr = next.get(j);
                for(int k = 0; k < graph.get(curr).size(); k++) {
                    int win = graph.get(curr).get(k);
                    if (!visited[win]) {
                        visited[win] = true;
                        next.add(win);
                        scoreBoard[i][win] = true;
                    }
                }
            }
        }
        
        // 순위 확정 가능 여부 확인
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                if(scoreBoard[i][j]) cnt++; // i가 이긴 선수
                if(scoreBoard[j][i]) cnt++; // i가 진 선수
            }
            if(cnt == n - 1) // 자신 제외한 모든 선수와의 관계가 확정
                answer++;
        }
        
        return answer;
    }
}
