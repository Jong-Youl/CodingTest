import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visit = new boolean[n];
        List<Integer> groupCnt = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                int size = 0;
                int curr = i;
                
                while (!visit[curr]) {
                    visit[curr] = true;
                    curr = cards[curr] - 1;
                    size++;
                }
                
                groupCnt.add(size);
            }
        }
        
        if (groupCnt.size() < 2) return 0;

        Collections.sort(groupCnt, Collections.reverseOrder());
        return groupCnt.get(0) * groupCnt.get(1);
    }
}
