class Solution {

    public int solution(int[] diffs, int[] times, long limit) {
        // level >= diff -> time 만큼 사용
        // level < diff -> (diff - level) * time_cur + time_prev
        // limit 안에 해결해야함
        int left = 1, right = 0;
        
        for(int i = 0; i < diffs.length; i++) {
            right = Math.max(right, diffs[i]);
        }
        
        while(left < right) {
            int level = (left + right) / 2;
            int timePrev = 0;
            long spentTime = 0L;    
          
            for(int i = 0; i < diffs.length; i++) {
                int diff = diffs[i], time = times[i];
                
                if(level >= diff) {
                    spentTime += time;
                }
                else {
                    spentTime += (diff - level) * (time + timePrev) + time;
                }
              
                if(spentTime > limit) break;
                timePrev = time;
            }
            
            // 가능하면 최솟값을 더 낮춤
            if(limit >= spentTime)
                right = level;
            // 안되면 최솟값을 높임
            else 
                left = level + 1;
        }
        

        return left;
    }
}