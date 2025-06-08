import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int row = land.length;
        int col = land[0].length;
        boolean[][] visit = new boolean[row][col];
        int[][] groupMap = new int[row][col]; // 덩어리 id 저장
        Map<Integer, Integer> oilSize = new HashMap<>(); // 덩어리 id -> 크기

        int groupId = 1;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (land[r][c] == 1 && !visit[r][c]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{r, c});
                    visit[r][c] = true;

                    int size = 1;
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{r, c});

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int i = 0; i < 4; i++) {
                            int nr = curr[0] + dr[i];
                            int nc = curr[1] + dc[i];
                            if (nr >= 0 && nr < row && nc >= 0 && nc < col &&
                                    land[nr][nc] == 1 && !visit[nr][nc]) {
                                visit[nr][nc] = true;
                                q.add(new int[]{nr, nc});
                                list.add(new int[]{nr, nc});
                                size++;
                            }
                        }
                    }

                    for (int[] pos : list) {
                        groupMap[pos[0]][pos[1]] = groupId;
                    }
                    oilSize.put(groupId, size);
                    groupId++;
                }
            }
        }

        int answer = 0;
        for (int c = 0; c < col; c++) {
            Set<Integer> seenGroups = new HashSet<>();
            int sum = 0;
            for (int r = 0; r < row; r++) {
                int gid = groupMap[r][c];
                if (gid > 0 && !seenGroups.contains(gid)) {
                    sum += oilSize.get(gid);
                    seenGroups.add(gid);
                }
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
