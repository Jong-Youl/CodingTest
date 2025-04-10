import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visitedPaths = new HashSet<>();
        int x = 0, y = 0;
        int answer = 0;

        Map<Character, int[]> dMap = new HashMap<>();
        dMap.put('U', new int[]{0, 1});
        dMap.put('D', new int[]{0, -1});
        dMap.put('L', new int[]{-1, 0});
        dMap.put('R', new int[]{1, 0});

        for (char dir : dirs.toCharArray()) {
            int nx = x + dMap.get(dir)[0];
            int ny = y + dMap.get(dir)[1];

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            String path1 = x + "," + y + "," + nx + "," + ny;
            String path2 = nx + "," + ny + "," + x + "," + y;

            if (!visitedPaths.contains(path1)) {
                visitedPaths.add(path1);
                visitedPaths.add(path2);
                answer++;
            }

            x = nx;
            y = ny;
        }

        return answer;
    }
}
