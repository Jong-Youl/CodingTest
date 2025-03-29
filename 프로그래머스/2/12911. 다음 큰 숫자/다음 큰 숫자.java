class Solution {
    public int solution(int n) {
        int answer = 0;
        String target = Integer.toString(n, 2);
        int tCnt = getBinaryCnt(target);
                
        String curr = "";
        while(answer == 0) {
            n++;
            curr = Integer.toString(n, 2);
            int cCnt = getBinaryCnt(curr);
            
            if(cCnt == tCnt)
                answer = n;
        }
        
        return answer;
    }
    
    
    public int getBinaryCnt(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1')
                result++;
        }
        
        return result;
    }
}