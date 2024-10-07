class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int n = park.length;        
        int m = park[0].length();
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        p: for (int r = 0; r < n; r++) {
            String str = park[r];
            for (int c = 0; c < m; c++) {
                if (str.charAt(c) == 'S') {
                    answer[0] = r;
                    answer[1] = c;
                    break p;
                }
            }
        }
        
        for (int i = 0; i < routes.length; i++) {
            String[] command = routes[i].split(" ");
            int num = Integer.parseInt(command[1]);
    
            int dir;
            switch (command[0]) {
                case "N": dir = 0; break;
                case "S": dir = 1; break;
                case "W": dir = 2; break;
                default: dir = 3; break;  // "E"
            }

            boolean isAble = true;
            
            for (int j = 1; j <= num; j++) {
                int nr = answer[0] + j * dr[dir];
                int nc = answer[1] + j * dc[dir];
                
                if (!checkIndex(nr, nc, n, m) || park[nr].charAt(nc) == 'X') {
                    isAble = false;
                    break;
                }
            }
            
            if (isAble) {
                answer[0] += num * dr[dir];
                answer[1] += num * dc[dir];
            } 
        }
        
        return answer;
    }
    
    public boolean checkIndex(int r, int c, int maxR, int maxC) {
        return r >= 0 && c >= 0 && r < maxR && c < maxC;
    }
}
