import java.util.*;

class Solution {
    // 최대비용
    private int maxCost = 100 * 1000 + 1;
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = 0;
        int size = onboard.length;
        
        t1 += 10; t2 += 10; int t = temperature + 10;
        int [][] dp = new int [size][51];        
        
        for(int i = 0; i < size; i++){
            Arrays.fill(dp[i], maxCost);
        }
        
        // 시작 온도 = 실외 온도
        dp[0][t] = 0;
        
        for(int i = 0; i < size - 1; i++){
            for(int j = 0; j <= 50; j++){
                // 승객 탑승 시점에 적정 온도가 아니면 패스
                if(onboard[i] == 1 && (j < t1 || t2 < j)) 
                    continue;  
                // 에어컨 ON
                // 현재 온도 유지
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + b);
                // 현재 온도에서 감소
                if(j >= 1) 
                    dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j] + a);
                // 현재 온도에서 증가
                if(j < 50) 
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + a);
                
                // 에어컨 OFF
                if(t == j)
                    // 온도 유지 
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
                else if(t > j && j < 50)
                    // 온도 상승
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]);
                else if(t < j && j >= 1)
                    // 온도 하락 
                    dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j]);
            }
        }
        
        answer = maxCost;
        for(int i = 0; i <= 50; i++){
            if(onboard[size - 1] == 1 && (i < t1 || t2 < i)) continue; // 마지막에 승객이 탑승했다면 적정 온도만 가능 
            answer = Math.min(answer, dp[size - 1][i]);
        }
        
        return answer;
    }
}