import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        boolean[] visit = new boolean[numbers.length()];
        
        comb(0, "", numbers, visit, set);
        
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }

    private void comb(int depth, String curr, String numbers, boolean[] visit, Set<Integer> set) {
        if (!curr.isEmpty()) {
            set.add(Integer.parseInt(curr));
        }
        if (depth == numbers.length()) {
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                comb(depth + 1, curr + numbers.charAt(i), numbers, visit, set);
                visit[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
