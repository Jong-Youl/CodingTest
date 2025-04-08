import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        Set<String> posSet = new HashSet<>();
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length - 1; i++) {
            long a = line[i][0], b = line[i][1], e = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                long c = line[j][0], d = line[j][1], f = line[j][2];

                long det = a * d - b * c;
                if (det == 0) 
                    continue; 
                
                long xNumer = b * f - e * d;
                long yNumer = e * c - a * f;

                if (xNumer % det != 0 || yNumer % det != 0) 
                    continue;
                
                long x = xNumer / det;
                long y = yNumer / det;

                posSet.add(x + "," + y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }

        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        char[][] board = new char[height][width];
        for (int i = 0; i < height; i++)
            Arrays.fill(board[i], '.');

        for (String s : posSet) {
            String[] parts = s.split(",");
            int x = (int)(Long.parseLong(parts[0]) - minX);
            int y = (int)(maxY - Long.parseLong(parts[1])); 
            
            board[y][x] = '*';
        }

        String[] answer = new String[height];
        for (int i = 0; i < height; i++)
            answer[i] = new String(board[i]);

        return answer;
    }
}
