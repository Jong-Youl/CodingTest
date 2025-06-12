import java.util.*;

class Solution {
    List<String> route = new ArrayList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            PriorityQueue <String> pq;
            if(!map.containsKey(ticket[0])) {
                pq = new PriorityQueue<>();
            }
            else {
                pq = map.get(ticket[0]);
            }
            pq.add(ticket[1]);
            map.put(ticket[0], pq);
        }

        dfs("ICN");

        return route.toArray(new String[0]);
    }

    void dfs(String airport) {
        PriorityQueue<String> dests = map.get(airport);
        while (dests != null && !dests.isEmpty()) {
            dfs(dests.poll());
        }
        route.add(0, airport); // 역순으로 넣음 (post-order)
    }
}
