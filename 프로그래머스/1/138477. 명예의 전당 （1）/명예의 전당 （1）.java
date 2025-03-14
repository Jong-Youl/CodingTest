import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int size = score.length;
        int[] answer = new int [size];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < size; i++) {
            pq.add(score[i]);
            
            if(pq.size() > k) 
                pq.poll();
            
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}