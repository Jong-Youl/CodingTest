import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        List<Character> skips = new ArrayList<>();
        
        for(char c : skip.toCharArray()) {
            skips.add(c);
        }
        
        for(char c : s.toCharArray()) {
            for(int i = 0; i < index; i++) {
                c = stepUp(c);
                while(skips.contains(c)) {
                    c = stepUp(c);
                }
            }
            answer.append(c);
        }
        
        return answer.toString();
    }
    
    public char stepUp(char c) {
        c++;
        if(c > 'z')
            c = 'a';
            
        return c;
    }
}