import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        /*
            일정금액 지불 -> 10일 간 회원자격 부여
            매일 한 가지 제품을 할인하는 행사 진행 (할인 제품 한 개씩만 구매 가능)
        */
        // name, cnt;
        HashMap<String, Integer> target = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++)
            target.put(want[i], number[i]);
        
        for(int i = 0; i < 10; i++)
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
           
        int st = 0;
        int ed = 10;          
        while(ed <= discount.length){
            boolean isCollect = true;
            // map 확인
            for(String key : target.keySet()) {
                if(!map.containsKey(key) || target.get(key) != map.get(key)) {
                    isCollect = false;
                    break;
                }
            }

            if(isCollect)
                answer++;
            
            if (ed == discount.length) 
                break;
            if (map.get(discount[st]) == 0) 
                map.remove(discount[st]);
            else
                map.put(discount[st], map.get(discount[st]) - 1);
            map.put(discount[ed], map.getOrDefault(discount[ed], 0) + 1);
            
            st++;
            ed++;
        }
        
        
        return answer;
    }
}