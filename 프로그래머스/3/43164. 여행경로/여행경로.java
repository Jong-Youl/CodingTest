import java.util.*;

class Solution {
    List<String> route = new ArrayList<>();
    boolean[] visit;
    int size;
    public String[] solution(String[][] tickets) {
        List<String> result = new ArrayList<>();
        size = tickets.length;
        visit = new boolean[size];

        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        dfs("ICN", "ICN", tickets, 0);

        return route.get(0).split(" ");
    }

    public void dfs(String curr, String path, String[][] tickets, int cnt) {
        if (cnt == size) {
            route.add(path);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (!visit[i] && tickets[i][0].equals(curr)) {
                visit[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, cnt + 1);
                visit[i] = false;
            }
        }
    }
}
