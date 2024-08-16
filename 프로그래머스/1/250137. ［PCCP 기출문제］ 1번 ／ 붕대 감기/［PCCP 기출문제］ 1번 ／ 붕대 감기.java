class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        /*
            붕대감기
            1. t초동안 붕대를 감음
            2. 1초마다 X만큼 체력회복
            3. t초 연속으로 붕대 감으면 y만큼 추가 회복
            4. 최대 체력을 넘을 순 없음
            
            기술 중단되는 경우
            1. 몬스터에게 공격을 당하는 순간 -> 기술 취소 -> 붕대감기 다시 시작 (연속 성공 시간 -> 0)
            
            캐릭터는 생존할 수 있는지?
        */
        int maxHealth = health;
        int idx = 0;
        int time = 0;
        int continueTime = 0;
        
        while(idx < attacks.length) {
            if(time == attacks[idx][0]) {
                continueTime = 0;
                health -= attacks[idx++][1];
                
                if(health <= 0)
                    return -1;
            }
            else {
                health += bandage[1];
                continueTime++;
                if(continueTime == bandage[0]) {
                    continueTime = 0;
                    health += bandage[2];
                }

                if(health > maxHealth)
                    health = maxHealth;
            }
            
            time++;
        }
        
        return health;
    }
}