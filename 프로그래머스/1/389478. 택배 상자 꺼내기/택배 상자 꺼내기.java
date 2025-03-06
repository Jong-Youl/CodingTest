class Solution {
    public int solution(int n, int w, int num) {
        int h = (n / w) + 1;
        int [][] map = new int [h][w];
        boolean b = true;
        int boxNumber = 1;
        
        for(int r = h - 1; r >= 0; r--) {
            if(b) {
                for(int c = 0; c < w; c++) {
                    if(boxNumber <= n)
                        map[r][c] = boxNumber++;
                }
                b = false;
            }
            else {
                for(int c = w - 1; c >= 0; c--) {
                    if(boxNumber <= n)
                        map[r][c] = boxNumber++;
                }
                b = true;
            }
        }
        
        int tR = 0;
        int tC = 0;
     p: for(int r = 0; r < h; r++) {
            for(int c = 0; c < w; c++) {            
                if(map[r][c] == num) {
                    tR = r;
                    tC = c;
                    break p;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i <= tR; i++) {
            if(map[i][tC] != 0)
                answer++;
        }

        return answer;
    }
}