import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int [] xCnt = new int [10];
        int [] yCnt = new int [10];
        
        for(char c : X.toCharArray()) 
            xCnt[c - '0']++;
        for(char c : Y.toCharArray()) 
            yCnt[c - '0']++;
        
        List<Integer> tmp = new ArrayList<>();
        
        for(int i = 0; i < 10; i++) {
            if(xCnt[i] > 0 && yCnt[i] > 0) {
                for(int j = 0; j < Math.min(xCnt[i], yCnt[i]); j++)
                    tmp.add(i);
            }
        }
        
        if(tmp.size() == 0)
            return "-1";
        
        Collections.sort(tmp);
        
        if(tmp.get(tmp.size() - 1) == 0)
            return "0";
        
        for(int i = tmp.size() - 1; i >= 0; i--) 
            sb.append(tmp.get(i));
        
        return sb.toString();
    }
}