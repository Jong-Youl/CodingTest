class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int [queries.length]; 
        /*
            직사각형 모양의 테두리 범위를 시계방향으로 회전
        */
        int [][] map = new int [rows][columns];
        int element = 1;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++)
                map[r][c] = element++;
        }
        
        int idx = 0;
        for(int [] arr : queries) {
            int r1 = arr[0] - 1;
            int c1 = arr[1] - 1;
            int r2 = arr[2] - 1;
            int c2 = arr[3] - 1;
            // 테두리 회전
            int prev = map[r1][c1]; // 첫 번째 값 저장
            int min = prev;

            // 상단 (좌 -> 우)
            for (int c = c1; c < c2; c++) {
                int temp = map[r1][c + 1];
                map[r1][c + 1] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            // 우측 (상 -> 하)
            for (int r = r1; r < r2; r++) {
                int temp = map[r + 1][c2];
                map[r + 1][c2] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            // 하단 (우 -> 좌)
            for (int c = c2; c > c1; c--) {
                int temp = map[r2][c - 1];
                map[r2][c - 1] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            // 좌측 (하 -> 상)
            for (int r = r2; r > r1; r--) {
                int temp = map[r - 1][c1];
                map[r - 1][c1] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            // 최소값 저장
            answer[idx++] = min;
        }
        
        return answer;
    }
    
}