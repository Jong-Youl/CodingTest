import java.util.*;

class Solution {
    
    public int min = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        // total
        dfs(picks[0], picks[1], picks[2], 0, minerals, 0);
        
        return min;
    }
    
    public void dfs(int dia, int iron, int stone, int depth, String [] minerals, int stamina) {
        //picks에 다 0이거나, 광물이 더 없으면 종료
        if( (dia == 0 && iron == 0 && stone == 0) || depth == minerals.length) {
            min = Math.min(min, stamina);
            return;
        }
        
        // 곡괭이를 하나씩 고름
        int cnt = 0, sum1 = 0, sum2 = 0, sum3 = 0;
        
        while(cnt < 5) {
            if(minerals[depth + cnt].equals("diamond")) {
                sum2 += 5;
                sum3 += 25;
            }
            else if (minerals[depth + cnt].equals("iron")) {
                sum2++;
                sum3 += 5;
            }
            else {
                sum2++;
                sum3++;
            }
            sum1++;
            cnt++;
            
            if(depth + cnt == minerals.length)
                break;
        }
        
        // && stamina + sum1 < min
        if(dia > 0)
            dfs(dia - 1, iron, stone, depth + cnt, minerals, stamina + sum1);
        
        if(iron > 0)
            dfs(dia, iron - 1, stone, depth + cnt, minerals, stamina + sum2);
        
        if(stone > 0)
            dfs(dia, iron, stone - 1, depth + cnt, minerals, stamina + sum3);
    }
}