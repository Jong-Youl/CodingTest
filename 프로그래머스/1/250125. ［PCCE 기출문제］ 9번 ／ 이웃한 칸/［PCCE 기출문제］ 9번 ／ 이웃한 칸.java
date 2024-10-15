class Solution {
    public int solution(String[][] board, int h, int w) {
        int [] dr = {-1, 1, 0, 0};
        int [] dc = {0, 0, -1, 1};
        
        int answer = 0;
        String target = board[h][w];
        
        for(int i = 0; i < 4; i++) {
            int nr = h + dr[i];
            int nc = w + dc[i];
            
            if(0 <= nr && 0 <= nc && nr < board.length && nc < board[0].length && board[nr][nc].equals(target))
                answer++;
        }
        
        return answer;
    }
}