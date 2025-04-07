class Solution {
    public int solution(int n) {
        int answer = 0;
        int mod = 1_000_000_007;
        
        int [] dp = new int [n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            dp[i] = (int) ((dp[i - 1] + dp[i - 2]) % mod);
        }
        
        answer = dp[n];
        return answer;
    }
}

/*
    n = 1 -> 1
    n = 2 -> 2
    n = 3 -> 3
    n = 4 -> 5
    N = 5 -> 
*/