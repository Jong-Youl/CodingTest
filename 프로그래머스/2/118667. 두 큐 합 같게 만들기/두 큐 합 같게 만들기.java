import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long total1 = 0;
        long total2 = 0;
        
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        for(int i = 0; i < queue1.length; i++) {
            total1 += queue1[i];
            total2 += queue2[i];
            
            Long curr1 = 0L + queue1[i];
            Long curr2 = 0L + queue2[i];
            q1.add(curr1);
            q2.add(curr2);
        }
        
        
        // 홀수면 못나눔
        if(total1 + total2 % 2 == 1) return -1;
        // 같으면 안움직여도 됨
        if(total1 == total2) return 0;
        // 둘 다 아닌 경우
        while(true) {
            // q1 -> q2, q2 -> q1, q1 -> q2 이렇게 돌아도 안되면 더 볼 필요 없음
            if(answer == 3 * queue1.length) return -1;
            
            long tmp = 0;
            if(!q1.isEmpty() && total1 > total2) {
                tmp = q1.poll();
                total1 -= tmp;
                total2 += tmp;
                q2.add(tmp);
            }
            else if (!q2.isEmpty() && total2 > total1) {
                tmp = q2.poll();
                total2 -= tmp;
                total1 += tmp;
                q1.add(tmp);
            }
            else 
                break;
            
            answer++;
        }
        
        
        return answer;
    }
}