import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int [] arr;
    private static int [] segmentTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int [N + 1];
        segmentTree = new int [N * 4];

        for(int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        init(1, N, 1);
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            sb.append(getMin(1, N, 1, left, right)).append("\n");
        }
        System.out.print(sb);
    }
    private static int getMin(int start, int end, int node, int left, int right) {
        if(end < left || right < start) return Integer.MAX_VALUE;
        if(left <= start && end <= right) return segmentTree[node];

        int mid = (start + end) / 2;
        return Math.min(getMin(start, mid, node * 2, left, right), getMin(mid + 1, end, node * 2 + 1, left, right));
    }
    private static int init(int start, int end, int node) {
        if(start == end)
            return segmentTree[node] = arr[start];

        int mid = (start + end) / 2;
        return segmentTree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
    }
}