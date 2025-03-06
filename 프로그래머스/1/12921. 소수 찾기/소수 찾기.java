class Solution {
    public int solution(int n) {
        if(n < 2)
            return 0;
        if(n == 2)
            return 1;
        
        int answer = 1;
        for(int i = 3; i <= n; i += 2) {
            if(isPrime(i))
                answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n == 3) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }
}