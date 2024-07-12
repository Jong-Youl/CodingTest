import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static boolean result;
    private static int N, target;
    private static boolean [] visit;
    private static List<List<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        target = Integer.parseInt(st.nextToken());
        result = false;

        tree = new ArrayList<>();
        for(int i = 0; i <= N; i++)
            tree.add(new ArrayList<>());

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            tree.get(v1).add(v2);
            tree.get(v2).add(v1);
        }

        visit[start] = true;
        dfs(start, 1);
        if(!result)
            System.out.println("Second");
    }

    private static void dfs(int start, int cnt) {
        if(start == target) {
            result = true;
            System.out.println("First");
            return;
        }
        int canVisit = 0;
        int size = tree.get(start).size();
        for (int i = 0; i < size; i++) {
            if(!visit[tree.get(start).get(i)])
                canVisit++;
        }

        if(cnt % 2 == 0 && canVisit > 1) {
            result = true;
            System.out.println("Second");
            return;
        }

        for(int i = 0; i < tree.get(start).size(); i++){
            int next = tree.get(start).get(i);
            if(!visit[next]){
                visit[next] = true;
                dfs(next, cnt + 1);
                if(result) return;
                visit[next] = false;
            }
        }
    }
}