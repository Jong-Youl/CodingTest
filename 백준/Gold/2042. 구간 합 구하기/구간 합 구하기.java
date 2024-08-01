import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());// 숫자 갯수
        int M = Integer.parseInt(st.nextToken());// 숫자 변경 횟수
        int K = Integer.parseInt(st.nextToken());// 구간의 합을 구하는 횟수?

        long [] arr = new long [N];
        long [] dp = new long [N];

        long sum = 0L;
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            sum += arr[i];
            dp[i] = sum;
        }

        for(int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            long num1 = Long.parseLong(st.nextToken());
            long num2 = Long.parseLong(st.nextToken());

            if(cmd == 1) {
                long diff = num2 - arr[(int) (num1 - 1)];
                arr[(int)num1 - 1] = num2;
                for(int j = (int)num1 - 1; j < N; j++)
                    dp[j] += diff;
            }
            else {
                sb.append(dp[(int)num2 - 1] - dp[(int)num1 - 1] + arr[(int)num1 - 1]).append("\n");
            }
        }
        System.out.println(sb);
    }
}