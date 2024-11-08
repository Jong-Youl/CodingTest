class Solution {
    public int maxRevenue, maxSubscribers;
    public int[] discountRates = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        maxRevenue = 0;
        maxSubscribers = 0;

        // 모든 이모티콘에 대한 할인율 조합을 찾기
        findBestDiscounts(0, emoticons, new int[emoticons.length], users);

        // 16384 * 700 => 11,468,800
        // 최종 결과 반환
        return new int[]{maxSubscribers, maxRevenue};
    }

    private void findBestDiscounts(int depth, int[] emoticons, int[] discounts, int[][] users) {
        if (depth == emoticons.length) {
            // 설정된 할인율 조합으로 총 가입자 수와 매출 계산
            calculateResult(discounts, emoticons, users);
            return;
        }

        // 4 ^^ 7 => 16384
        for (int rate : discountRates) {
            discounts[depth] = rate;
            findBestDiscounts(depth + 1, emoticons, discounts, users);
        }
    }

    private void calculateResult(int[] discounts, int[] emoticons, int[][] users) {
        int currentRevenue = 0;
        int currentSubscribers = 0;

        // 각 사용자별로 구매액 및 가입 여부 계산
        // 100 * 7 => 700회
        // 100회
        for (int[] user : users) {
            int minDiscountRate = user[0];
            int budget = user[1];
            int userTotalCost = 0;

            // 이모티콘별로 할인율 적용하여 사용자 구매 비용 계산
            // 7회
            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= minDiscountRate) {
                    userTotalCost += emoticons[i] * (100 - discounts[i]) / 100;
                }
            }

            // 가입 조건 체크
            if (userTotalCost >= budget) {
                currentSubscribers++;
            } else {
                currentRevenue += userTotalCost;
            }
        }

        // 최대 가입자 수와 매출 갱신
        if (currentSubscribers > maxSubscribers || 
            (currentSubscribers == maxSubscribers && currentRevenue > maxRevenue)) {
            maxSubscribers = currentSubscribers;
            maxRevenue = currentRevenue;
        }
    }
}
