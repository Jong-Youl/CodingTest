import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0L;

        Stack<int[]> dStack = new Stack<>();
        Stack<int[]> pStack = new Stack<>();

        // 초기화
        for (int i = 0; i < n; i++) {
            if (deliveries[i] > 0) {
                dStack.add(new int[] {i + 1, deliveries[i]});
            }
            if (pickups[i] > 0) {
                pStack.add(new int[] {i + 1, pickups[i]});
            }
        }

        while (!dStack.isEmpty() || !pStack.isEmpty()) {
            // 가장 먼 위치 계산
            int farthest = Math.max(!dStack.isEmpty()? dStack.peek()[0] : 0,
                                !pStack.isEmpty() ? pStack.peek()[0] : 0);
            
            answer += farthest * 2;

            // 배달 처리
            int deliver = cap;
            while (deliver > 0 && !dStack.isEmpty()) {
                int[] curr = dStack.pop();
                if (deliver >= curr[1]) {
                    deliver -= curr[1];
                } else {
                    curr[1] -= deliver;
                    deliver = 0;
                    dStack.add(curr);
                }
            }

            // 픽업 처리
            int pickup = cap;
            while (pickup > 0 && !pStack.isEmpty()) {
                int[] curr = pStack.pop();
                if (pickup >= curr[1]) {
                    pickup -= curr[1];
                } else {
                    curr[1] -= pickup;
                    pickup = 0;
                    pStack.add(curr);
                }
            }
        }

        return answer;
    }
}
