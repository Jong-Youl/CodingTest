import java.util.*;

class Solution {
    // 함수의 경우 매개변수가 바뀌는걸 방지해야함
    public int[] solution(final String[] id_list, final String[] report, final int k) {
        
        int size = id_list.length;
        int[] answer = new int [size];
        boolean [][] checkList = new boolean [size][size];
        Map <String, Integer> map = new HashMap<>();
        
        // 각자의 신고 로그를 기록할 map
        int idx = 0;
        for(String id : id_list)
            map.put(id, idx++);
        
        for(String r : report) {
            String [] log = r.split(" ");
            
            int userId = map.get(log[0]);
            int targetId = map.get(log[1]);
            
            if(!checkList[targetId][userId])
                checkList[targetId][userId] = true;
        }

        List<Integer> tmp;
        for(int i = 0; i < checkList.length; i++) {
            int cnt = 0;
            tmp = new ArrayList<>();
            for(int j = 0; j < checkList[i].length; j++) {
                if(checkList[i][j] == true) {
                    cnt++;
                    tmp.add(j);
                }
            }
            
            if(cnt >= k) {
                for(int id : tmp)
                    answer[id]++;
            }
        }
        
        return answer;
    }
}