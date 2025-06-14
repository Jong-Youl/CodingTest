import java.util.*;

class Solution {
    
    public Set<Integer> set;

    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean [] visit = new boolean [numbers.length()];
        
        comb(0, new StringBuilder(), numbers, visit);
        
        for(int num : set) {
            if(isPrime(num)) 
                answer++;

        }

        return answer;
    }
    
    public void comb (int depth, StringBuilder sb, String numbers, boolean [] visit) {
        if(depth == numbers.length()) {
            if(sb.length() == 0)
                return;
            String tmp = sb.toString();
            set.add(Integer.parseInt(tmp));
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(visit[i])
                continue;
            
            int curr = numbers.charAt(i) - '0';
            // 넣지 않음
            comb(depth + 1, sb, numbers, visit);
            // 넣음
            StringBuilder currSb = new StringBuilder(sb.toString());
            if(curr == 0 && currSb.length() == 0)
                continue;
            
            currSb.append(curr);
            visit[i] = true;
            comb(depth + 1, currSb, numbers, visit);
            visit[i] = false;
        }
    }

        
    public boolean isPrime (int num) {
        if(num <= 1)
            return false;
        if(num <= 3)
            return true;
        
        if(num % 2 == 0)
            return false;
        
        for(int i = 3; i <= Math.sqrt(num); i += 2) {
            if(num % i == 0)
                return false;
        }
        
        return true;
    }
    
}