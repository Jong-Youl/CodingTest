class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        long[] cntWeight = new long[1001];
        long[] cntMul = new long[4001];

        for(int i = 0; i < weights.length; i ++) {
            long temp = cntWeight[weights[i]];
            int m2 = weights[i] * 2;
            int m3 = weights[i] * 3;
            int m4 = weights[i] * 4;
            
            if(temp > 0) {
                answer += temp;
                answer += cntMul[m2] - temp;
                answer += cntMul[m3] - temp;
                answer += cntMul[m4] - temp;
            } 
            else {
                answer += cntMul[m2];
                answer += cntMul[m3];
                answer += cntMul[m4];
            }

            cntWeight[weights[i]]++;
            cntMul[m2]++;
            cntMul[m3]++;
            cntMul[m4]++;
        }

        return answer;
    }
}