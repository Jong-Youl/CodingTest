class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String [] totalTime = video_len.split(":");
        String [] currTime = pos.split(":");
        String [] startTime = op_start.split(":");
        String [] endTime = op_end.split(":");
        
        int totalMin = Integer.parseInt(totalTime[0]);
        int totalSec = Integer.parseInt(totalTime[1]);
        
        int currMin = Integer.parseInt(currTime[0]);
        int currSec = Integer.parseInt(currTime[1]);

        int startMin = Integer.parseInt(startTime[0]);
        int startSec = Integer.parseInt(startTime[1]);

        int endMin = Integer.parseInt(endTime[0]);
        int endSec = Integer.parseInt(endTime[1]);

       if(startMin * 60 + startSec <= currMin * 60 + currSec && endMin * 60 + endSec >= currMin * 60 + currSec) {
                currMin = endMin;
                currSec = endSec;
       }
        
        for(int i = 0; i < commands.length; i++) {
            
            if(commands[i].equals("next")) {   
                currSec += 10;
                if(currSec >= 60) {
                    currMin++;
                    currSec %= 60;
                }
                // 최종 시간보다 크면 최종 시간에 맞춰줌
                if(totalMin * 60 + totalSec < currMin * 60 + currSec) {
                    currMin = totalMin;
                    currSec = totalSec;
                }    
            }         
            else {
                currSec -= 10;
                if(currSec < 0) {
                    currMin--;
                    currSec += 60;
                }
                // 시작 시간보다 작으면 시작 시간으로 맞춰줌
                if(currMin < 0) {
                    currMin = 0;
                    currSec = 0;   
                }
            }
            
            
            //현재 구간이 Openning 구간일 경우
            if(startMin * 60 + startSec <= currMin * 60 + currSec && endMin * 60 + endSec >= currMin * 60 + currSec) {
                currMin = endMin;
                currSec = endSec;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        
        sb.append(currMin < 10 ? ("0" + currMin): currMin).append(":").append(currSec < 10 ? ("0" + currSec): currSec);
        
        return sb.toString();
    }
}