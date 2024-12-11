import java.util.*;

class Solution {
    public int mergeCnt = 1;
    public int[][] isMerged = new int[51][51];

    public String[] solution(String[] commands) {
        List<String> pltList = new ArrayList<>();
        String[][] map = new String[51][51];

        for (int r = 0; r <= 50; r++)
            Arrays.fill(map[r], "EMPTY");

        for (String c : commands) {
            String[] cmdArr = c.split(" ");
            if (cmdArr[0].equals("UPDATE")) {
                if (cmdArr.length == 4)
                    updateByPos(cmdArr[1], cmdArr[2], cmdArr[3], map);
                else
                    updateByValue(cmdArr[1], cmdArr[2], map);
            }
            else if (cmdArr[0].equals("MERGE"))
                merge(cmdArr[1], cmdArr[2], cmdArr[3], cmdArr[4], map);
            else if (cmdArr[0].equals("UNMERGE"))
                unmerge(cmdArr[1], cmdArr[2], map);
            else
                pltList.add(map[Integer.parseInt(cmdArr[1])][Integer.parseInt(cmdArr[2])]);
        }

        return pltList.toArray(new String[0]);
    }

    public void updateByPos(String r1, String c1, String value, String[][] map) {
        int r = Integer.parseInt(r1);
        int c = Integer.parseInt(c1);
        map[r][c] = value;

        if (isMerged[r][c] != 0) {
            int group = isMerged[r][c];
            updateMergedCells(group, value, map);
        }
    }

    public void updateByValue(String v1, String v2, String[][] map) {
        for (int r = 1; r <= 50; r++) {
            for (int c = 1; c <= 50; c++) {
                if (map[r][c].equals(v1))
                    map[r][c] = v2;
            }
        }
    }

    public void merge(String r1, String c1, String r2, String c2, String[][] map) {
        if (r1.equals(r2) && c1.equals(c2)) return;

        int sr = Integer.parseInt(r1);
        int sc = Integer.parseInt(c1);
        int er = Integer.parseInt(r2);
        int ec = Integer.parseInt(c2);

        String value = !map[sr][sc].equals("EMPTY") ? map[sr][sc] : map[er][ec];
        map[sr][sc] = value;
        map[er][ec] = value;

        int newGroup = mergeCnt++;
        mergeCells(sr, sc, newGroup, value, map);
        mergeCells(er, ec, newGroup, value, map);
    }

    public void unmerge(String r1, String c1, String[][] map) {
        int r = Integer.parseInt(r1);
        int c = Integer.parseInt(c1);

        int group = isMerged[r][c];
        if (group == 0) return;

        String value = map[r][c];
        resetMergedCells(group, map);
        map[r][c] = value;
    }

    private void updateMergedCells(int group, String value, String[][] map) {
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                if (isMerged[i][j] == group) {
                    map[i][j] = value;
                }
            }
        }
    }
    
    private void mergeCells(int r, int c, int group, String value, String[][] map) {
        if (isMerged[r][c] != 0) {
            int oldGroup = isMerged[r][c];
            for (int i = 1; i <= 50; i++) {
                for (int j = 1; j <= 50; j++) {
                    if (isMerged[i][j] == oldGroup) {
                        isMerged[i][j] = group;
                        map[i][j] = value;
                    }
                }
            }
        } else {
            isMerged[r][c] = group;
        }
    }
    
    private void resetMergedCells(int group, String[][] map) {
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                if (isMerged[i][j] == group) {
                    map[i][j] = "EMPTY";
                    isMerged[i][j] = 0;
                }
            }
        }
    }
}