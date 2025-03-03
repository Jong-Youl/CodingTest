class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++) {
            int tH = schedules[i] / 100;
            int tM = schedules[i] % 100;
            int target = tH * 60 + tM + 10;
            int date = startday;
            int cnt = 0;
            
            for(int timeLog : timelogs[i]) {
                if(date <= 5) {
                    int currH = timeLog / 100;
                    int currM = timeLog % 100;
                    
                    int curr = currH * 60 + currM;
                    
                    if(target < curr)
                        break;
                    cnt++;
                }
                date++;
                if(date == 8) date = 1;
            }
            
            if(cnt == 5)
                answer++;
        }
        
        
        return answer;
    }
}