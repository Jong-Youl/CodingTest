class Solution {
    private int answer = 0;
    private boolean isDone = false;
    
    public int solution(String word) {
        char [] lst = {'A', 'E', 'I', 'O', 'U'};
        getCnt("", lst, word);
        
        return answer;
    }

    private void getCnt(String curr, char [] lst, String word) {
        if(curr.equals(word)){
            isDone = true;    
            return;
        }
        
        if(curr.length() == 5) return;

        for(int i = 0; i < lst.length; i++) {
            answer++;
            getCnt(curr + lst[i], lst, word);
            if(isDone) return;
        }
    }
}