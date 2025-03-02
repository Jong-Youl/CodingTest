import java.util.*;

class Solution {
    public int cnt = 0;

    public int solution(int[] nums) {
        cnt = 0;
        comb(nums, 0, 0, 0);
        return cnt;
    }

    public void comb(int[] arr, int sum, int idx, int depth) {
        if (depth == 3) { // 3개를 선택한 경우
            if (isPrime(sum))
                cnt++;
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            comb(arr, sum + arr[i], i + 1, depth + 1);
        }
    }

    public boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
