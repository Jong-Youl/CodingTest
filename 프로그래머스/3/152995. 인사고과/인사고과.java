import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        //완호 점수
        int[] target = scores[0];
        int totalScore = target[0] + target[1];
        // 근무태도점수 내림차순정렬.
        //동료평가점수 오름차순
        Arrays.sort(scores, (a, b) -> 
                    a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]
                   );
        
        ArrayList<Integer> ranking = new ArrayList<>();

        int maxScore = 0;
        
        for (int[] score : scores) {
            
            if (score[1] < maxScore) {
                // 폐급
                if (score.equals(target))
                    return -1;
            } else {
                // 에이스
                ranking.add(score[0] + score[1]);
                maxScore = Math.max(maxScore, score[1]);
            }
        }

        for(int i = 0; i < ranking.size(); i++){
            if(ranking.get(i) > totalScore) answer++;
        }        
        
        return answer;
    }
}