import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String [] todayInfo = today.split("\\.");
        Map<String, Integer> termMap = new HashMap<>();
        int tY = Integer.parseInt(todayInfo[0]), tM = Integer.parseInt(todayInfo[1]), tD = Integer.parseInt(todayInfo[2]); 
        
        for(String str : terms) {
            String [] curr = str.split(" ");
            termMap.put(curr[0], Integer.parseInt(curr[1]));
        }
        
        List<Integer> lst = new ArrayList<>();
        int idx = 0;
        System.out.println(Arrays.toString(todayInfo));
        for(String str : privacies) {
            idx++;
            String [] curr = str.split(" ");
            String [] currDate = curr[0].split("\\.");
            
            int y = Integer.parseInt(currDate[0]), m = Integer.parseInt(currDate[1]), d = Integer.parseInt(currDate[2]);
            m += termMap.get(curr[1]);
            d--;
            if(d == 0) {
                m--;
                d = 28;
            }
            
            if(m > 12) {
                y += (m - 1) / 12;
                m = (m - 1) % 12 + 1;
            }
            //today <= target + term(Month)       
            // 오늘보다 더 크면 제외 Year
            if(tY > y)
                lst.add(idx);
            else if (tY == y) {
                if(tM > m)
                    lst.add(idx);
                else if (tM == m){
                    if(tD > d)
                        lst.add(idx);
                }
            }
        }

        int [] answer = new int [lst.size()];
        idx = 0;
        for(int num : lst)
            answer[idx++] = num;
        return answer;
    }
}