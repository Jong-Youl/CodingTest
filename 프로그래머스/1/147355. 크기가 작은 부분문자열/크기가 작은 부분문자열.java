class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long target = Long.parseLong(p);
        
        StringBuilder curr = new StringBuilder();
        for(int i = 0; i < t.length() - p.length() + 1; i++) {    
            for(int j = i; j < i + p.length(); j++)
                curr.append(t.charAt(j));
                     
            if(Long.parseLong(curr.toString()) <= target) 
                answer++;
            
            curr.setLength(0);
        }
        
        return answer;
    }
}