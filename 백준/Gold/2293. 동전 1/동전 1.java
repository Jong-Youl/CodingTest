import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        int[] coin = new int[N];
        dp[0] = 1;

        for (int i = 0; i < N; i++)
            coin[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int c = coin[i];
            for(int j = 1; j <= K; j++) {
                if(j - c < 0) continue;
                dp[j] += dp[j - c];
            }
        }
        System.out.println(dp[K]);
    }
}