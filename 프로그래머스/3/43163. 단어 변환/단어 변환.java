import java.util.*;

class Solution {
    public class Node {
        String value;
        int cnt;
        
        Node (String value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        boolean [] visit = new boolean [words.length];
        
        for(int i = 0; i < words.length; i++) {
            if(isValid(begin, words[i])) {
                
                if(words[i].equals(target))
                    return 1;
                
                q.add(new Node(words[i], 1));
                visit[i] = true;
            }
        }
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            String currAlp = curr.value;
            int nextCnt = curr.cnt + 1;
            
            for(int i = 0; i < words.length; i++) {
                if(!visit[i] && isValid(currAlp, words[i])) {
                    if(words[i].equals(target))
                        return nextCnt;

                    q.add(new Node(words[i], nextCnt));
                    visit[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    public boolean isValid(String obj, String target) {
        int cnt = 0;
        for(int i = 0; i < obj.length(); i++) {
            if(obj.charAt(i) != target.charAt(i))
                cnt++;
        }
        
        return cnt == 1;
    }
}