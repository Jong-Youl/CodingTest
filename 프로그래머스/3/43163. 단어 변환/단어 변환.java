class Solution {
    public int min = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        dfs(0, begin, target, words, new boolean [words.length]);
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public void dfs(int cnt, String begin, String target, String [] words, boolean [] visit) {
        if(begin.equals(target)) {
            min = Math.min(min, cnt);
            return;
        }
                    
        for(int i = 0; i < words.length; i++) {
            if(!visit[i]) {
                int diffCnt = 0;
                for(int j = 0; j < begin.length(); j++) {
                    if(begin.charAt(j) != words[i].charAt(j))
                        diffCnt++;           
                }
                if(diffCnt > 1) continue;
                visit[i] = true;
                dfs(cnt + 1, words[i], target, words, visit);
                visit[i] = false;
            }
        }
    }
}