import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // 각 토핑의 빈도 수
        int variety = 0;
        int [] tCnt = new int [10_001];
        Set<Integer> tSet = new HashSet<>();
        
        for(int t : topping) {
            if(tCnt[t] == 0)
                variety++;
            tCnt[t]++;
        }
        
        for(int i = 0; i < topping.length; i++) {
            tSet.add(topping[i]);
            tCnt[topping[i]]--;
            if(tCnt[topping[i]] == 0)
                variety--;
            
            if(tSet.size() == variety)
                answer++;
        }
        
        return answer;
    }
}