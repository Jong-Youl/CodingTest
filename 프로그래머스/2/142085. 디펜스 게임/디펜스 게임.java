import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int e : enemy) {
            maxHeap.add(e);
            n -= e;
            
            if (n < 0) {
                if (k > 0) {
                    n += maxHeap.poll();
                    k--;
                } 
                else 
                    break;
            }
            answer++;
        }
        
        return answer;
    }
}