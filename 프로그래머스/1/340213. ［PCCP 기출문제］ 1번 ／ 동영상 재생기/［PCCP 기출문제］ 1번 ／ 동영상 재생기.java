class Solution {
    class Time {
        int m, s;
        
        Time (String s) {
            String [] split = s.split(":");
            this.m = Integer.parseInt(split[0]);
            this.s = Integer.parseInt(split[1]);
        }
        
        void moveNext(Time runningTime) {
            this.s += 10;
            if(this.s >= 60) {
                this.s %= 60;
                this.m++;
            }
            
            // running Time보다 크면
            if(this.m * 60 + this.s > runningTime.m * 60 + runningTime.s) {
                this.m = runningTime.m;
                this.s = runningTime.s;
            }
        }
        
        void movePrev() {
            this.s -= 10;
            if(this.s < 0) {
                // 끝지점인 경우
                if(this.m == 0) {
                    this.s = 0;
                }
                // 아닌 경우
                else {
                    this.m--;
                    this.s += 60;
                } 
            }
        }
        
        boolean isIn(Time t1, Time t2) {
            int st = t1.m * 60 + t1.s;
            int ed = t2.m * 60 + t2.s;
            int curr = this.m * 60 + this.s;
            
             return st <= curr && curr <= ed;
        }        
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        /*  
            기능
            1. prev (10초 전으로 이동)
            2. next (10초 후로 이동)
            3. 오프닝 건너뛰기
        */
        
        Time st = new Time(op_start);
        Time ed = new Time(op_end);
        Time runningTime = new Time(video_len);
        Time curr = new Time(pos);
        
        // 현재 시간이 오프닝 타임에 껴있으면 끝나는 지점으로 옮김
        if(curr.isIn(st, ed))
            curr = new Time(op_end);
         
        for(String command : commands) {
            if(command.equals("next"))
                curr.moveNext(runningTime);
            else
                curr.movePrev();

            if(curr.isIn(st, ed))
                curr = new Time(op_end);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(curr.m < 10 ? ("0" + curr.m): curr.m).append(":").append(curr.s < 10 ? ("0" + curr.s): curr.s);

        answer = sb.toString();
        return answer;
    }
}