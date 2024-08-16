class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
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