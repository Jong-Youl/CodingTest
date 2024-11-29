class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int sameNumCnt = 0;
        int unknownCnt = 0;
        
        boolean [] visit = new boolean [46]; 
        for(int num : win_nums)
            visit[num] = true;
        
        for(int num : lottos) {
            if(num == 0) unknownCnt++;
            else if(visit[num])    
                sameNumCnt++;
        }
        
        int best = getRank(sameNumCnt + unknownCnt);
        int worst = getRank(sameNumCnt);
        
        return new int [] {best, worst};
    }
    
    public int getRank(int num) {
        int result = 0;
        switch (num) {
            case 6:
                result = 1;
                break;
            case 5:
                result = 2;
                break;
            case 4:
                result = 3;
                break;
            case 3:
                result = 4;
                break;
            case 2:
                result = 5;
                break;
            default:
                result = 6;
                break;
        }
        
        return result;
    }
}