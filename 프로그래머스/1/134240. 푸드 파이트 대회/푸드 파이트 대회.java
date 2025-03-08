class Solution {
    public String solution(int[] food) {
        StringBuilder half = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i = 1; i < food.length; i++) {
            int fCnt = food[i] / 2;
            
            for(int j = 0; j < fCnt; j++) 
                half.append(i);
        }
        
        answer.append(half.toString()).append(0).append(half.reverse().toString());
        
        return answer.toString();
    }
}