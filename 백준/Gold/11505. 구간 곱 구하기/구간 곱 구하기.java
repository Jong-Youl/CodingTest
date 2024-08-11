import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, K;
    public static long [] arr, segmentTree;
    public static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int h = (int)Math.ceil(Math.log(N)/Math.log(2));
        arr = new long [N + 1];
        segmentTree = new long [(int)Math.pow(2, h + 1)];

        for(int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        init(1, N, 1);

        for(int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if(cmd == 1) {
                arr[num1] = num2;
                update(1, N, 1, num1, num2);
            }
            else
                sb.append(getTimes(1, N, 1, num1, num2) % mod).append("\n");
        }

        System.out.println(sb);
    }

    private static long init(int start, int end, int node) {
        if(start == end) {
            return segmentTree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return segmentTree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % mod;
    }

    private static long update(int start, int end, int node, int idx, long newVal) {
        if(end < idx || idx < start) return segmentTree[node];
        if(end == start) return segmentTree[node] = newVal;

        int mid = (start + end) / 2;
        return segmentTree[node] = (update(start, mid, node * 2, idx, newVal) * update(mid + 1, end, node * 2 + 1, idx, newVal)) % mod;
    }

    private static long getTimes(int start, int end, int node, int left, int right) {
        if(end < left || right < start) return 1;
        if(left <= start && end <= right) return segmentTree[node];

        int mid = (start + end) / 2;
        return (getTimes(start, mid, node * 2, left, right) * getTimes(mid + 1, end, node * 2 + 1, left, right)) % mod;
    }
}