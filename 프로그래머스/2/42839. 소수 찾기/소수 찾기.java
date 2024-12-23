import java.util.*;

class Solution {
    private boolean [] visit;
    private Set <Integer> set = new HashSet<>();   
    
    public int solution(String numbers) {
        int answer = 0;
        visit = new boolean [numbers.length()];
        comb(0, "", numbers);

        for(int num : set) {
            if(isPrime(num)) {
                answer++;
            }   
        }
        return answer;
    }
    
    public void comb(int depth, String curr, String numbers) {
        if(depth == numbers.length()) {
            if(curr != "")
                set.add(Integer.parseInt(curr));
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(curr.length() == 0 && (numbers.charAt(i) - '0') == 0)
                continue;
            if(!visit[i]) {
                visit[i] = true;
                comb(depth + 1, curr, numbers);
                comb(depth + 1, curr + numbers.charAt(i), numbers);
                visit[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if(num <= 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i ++)
            if(num % i == 0) return false;
        
        return true;
    }
}