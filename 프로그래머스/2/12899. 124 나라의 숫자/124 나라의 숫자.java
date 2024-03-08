class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        while(n > 0) {
            int tmp = n % 3;
            n /= 3;
            
            //3의 배수일 때
            if(tmp == 0) {
                tmp = 4;
                n--;
            }
            answer.insert(0, tmp);           
        }
        
        return answer.toString();
    }
}