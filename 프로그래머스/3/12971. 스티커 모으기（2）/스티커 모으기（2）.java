class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        if(sticker.length == 1)
            return sticker[0];
        else if (sticker.length == 2)
            return Math.max(sticker[0], sticker[1]);
        
        // 스티커를 더해서 가장 큰 값을 구하려고 함, 인접 칸은 고를 수 없음
        // 첫 번째를 선택하느냐, 마지막을 선택하느냐
        int [] dp1 = new int [sticker.length - 1];
        int [] dp2 = new int [sticker.length];
        
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for(int i = 2; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }
        
        for(int i = 2; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }
        
        answer = Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
        
        return answer;
    }
}