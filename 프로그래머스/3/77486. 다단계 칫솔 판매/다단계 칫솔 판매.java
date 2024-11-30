import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        // Map으로 이름과 인덱스 매핑
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
        }

        // 수익 분배
        for (int i = 0; i < seller.length; i++) {
            String current = seller[i];
            int profit = amount[i] * 100; // 금액 환산 (각 판매당 100원을 기준)

            while (!current.equals("-")) {
                int idx = map.get(current);
                int distributed = profit / 10; // 10% 상위 전달
                answer[idx] += profit - distributed; // 남은 금액 저장

                // 다음 상위 추천인으로 이동
                profit = distributed;
                current = referral[idx];

                if (profit == 0) break; // 전달 금액이 0이면 중단
            }
        }

        return answer;
    }
}
