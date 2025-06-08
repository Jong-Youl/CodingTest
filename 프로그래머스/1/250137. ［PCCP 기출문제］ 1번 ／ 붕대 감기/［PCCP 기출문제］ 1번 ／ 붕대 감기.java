class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int costTime = bandage[0];
        int hs = bandage[1];
        int eh = bandage[2];
        int currHp = health;
        int prev = 0;
        
        for(int [] attack : attacks) {
            // 데미지를 받은 상태라면 회복해야함
            if(currHp < health) {
                int diff = attack[0] - prev - 1;
                
                currHp += diff * hs;
                currHp += (diff / costTime) * eh;
                currHp = Math.min(currHp, health); 
            }
            
            prev = attack[0];
            currHp -= attack[1];
            
            if(currHp <= 0)
                break;
        }
        
        return currHp > 0 ? currHp : -1;
    }
}