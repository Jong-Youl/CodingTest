class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        long result1 = 0;
        long result2 = 0;
        
        int palse1 = -1;
        int palse2 = 1;
        
        int [] sequence1 = new int [sequence.length];
        int [] sequence2 = new int [sequence.length];
        
        for(int i = 0; i < sequence.length; i++) {
            int tmp = sequence[i];
            sequence1[i] = tmp * palse1;
            sequence2[i] = tmp * palse2;
            
            palse1 *= -1;
            palse2 *= -1;
        }
        
        long sum1 = 0;
        long sum2 = 0;
        
        //total이 0보다 작아지면 문제가 생김
        for(int i = 0; i < sequence.length; i++) {
            sum1 += sequence1[i];
            sum2 += sequence2[i];
            
            result1 = Math.max(result1, sum1);
            result2 = Math.max(result2, sum2);
            
            if(sum1 < 0) {
                sum1 = 0;
            }            
            if(sum2 < 0) {
                sum2 = 0;
            }
        }
        answer = Math.max(result1, result2);
        
        return answer;
    }
}