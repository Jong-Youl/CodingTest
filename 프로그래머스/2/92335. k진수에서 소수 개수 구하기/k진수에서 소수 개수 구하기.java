class Solution {
    public int solution(final int n, final int k) {
        int answer = 0;

        String tNum = getTransratedNum(n, k);
        // 결국 옆에 0이 있냐 없냐의 문제이기 때문에 0을 기준으로 나눔
        String [] target = tNum.split("0");
        
        for(String t : target) {
            if(t.equals("")) continue;
            if(isPrime(t))
                answer++;
        }

        return answer;
    }

    public boolean isPrime(String s) {
        double num = Double.parseDouble(s);

        if(num == 1) return false;
        
        for(double i = 2; i <= Math.sqrt(num); i++)
            if(num % i == 0) return false;

        return true;
    }

    public String getTransratedNum(final int n, final int k){
        StringBuilder sb = new StringBuilder();
        
        int curr = n;
        while(curr > 0) {
            sb.append(curr % k);
            curr /= k;
        }

        return sb.reverse().toString();
    }

}