import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                sb.append(c);
                continue;
            }
                
            for(int i = 0; i < n; i++) {
                if(c == 'z')
                    c = 'a';
                else if (c == 'Z')
                    c = 'A';
                else
                    c++;
            }
            
            sb.append(c);
        }
        /*
            a = 97, z = 122
            A = 65, Z = 90
        */
        return sb.toString();
    }
}