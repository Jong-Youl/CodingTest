import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        int size = info.length;
        int inf = 361;
        int [][] dp = new int [size + 1][m];
        
        for(int i = 0; i <= size; i++)
            Arrays.fill(dp[i], inf);
        
        dp[0][0] = 0;
        // 둘 다 각각 n과 m을 넘지 않도록 모든 물건을 훔쳤을 때, A도둑이 남긴 흔적의 누적 갯수의 최솟값
        for(int i = 1; i <= size; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];
            
            for(int j = 0; j < m; j++){
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                // b가 가져갈 수 있으면
                if(j + b < m){
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i-1][j]);
                }
            }            
        }
        
        answer = inf;
        for(int i = 0; i < m; i++)
            answer = Math.min(dp[size][i], answer);
        
            
        return answer >= n ? -1 : answer;        
    }
}