class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int [] scores = new int [3];
        // 점수, 보너스, 옵션
        // 점수 -> 1 ~ 10 ,보너스 (S,D,T), 옵션 *, #
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < dartResult.length(); i++) {
            char curr = dartResult.charAt(i);
            if(curr - '0' < 10 && curr - '0' >= 0) {
                sb.append(curr);
            }
            else if (curr > 65) {
                int times;
                if(curr == 'S')
                    times = 1;
                else if(curr == 'D')
                    times = 2;
                else
                    times = 3;
                scores[idx++] = (int) Math.pow(Integer.parseInt(sb.toString()), times);
                sb.setLength(0);
            }
            else {
                if(curr == '*') {
                    if(idx >= 2)
                        scores[idx - 2] *= 2;
                    scores[idx - 1] *= 2;
                }
                else {
                    scores[idx - 1] *= -1;
                }
            }
        }
        
        for(int score : scores) {
            answer += score;    
        }
        
        return answer;
    }
}