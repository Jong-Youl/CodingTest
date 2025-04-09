import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++)
            queue.add(new int[] { priorities[i], i });
        
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            boolean hasHigher = false;

            for (int[] q : queue) {
                if (q[0] > curr[0]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) 
                queue.add(curr); 
            else {
                cnt++;
                if (curr[1] == location)
                    break;
            }
        }

        return cnt;
    }
}
