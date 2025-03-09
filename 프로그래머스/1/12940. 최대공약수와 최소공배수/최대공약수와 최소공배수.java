class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int [2];
        int k = 1;
        for(int i = 2; i <= Math.min(n, m); i++) {
            while(n % i == 0 && m % i == 0) {
                k *= i;
                n /= i;
                m /= i;
            }
        }
        
        answer[0] = k;
        answer[1] = k * n * m;
        
        return answer;
    }
}