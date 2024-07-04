import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] dp = new int [K + 1];
        int [] coin = new int [N];

        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            if(coin[i] <= K) dp[coin[i]] = 1;
        }

        // 가치
        for(int i = 0; i < K; i++) {
            if(dp[i] == 0) continue;
            // 동전
            for(int j = 0; j < N; j++) {
                if(i + coin[j] <= K && (dp[i + coin[j]] == 0 || dp[i + coin[j]] > dp[i] + 1))
                    dp[i + coin[j]] = dp[i] + 1;
            }
        }
        System.out.println(dp[K] == 0? -1:dp[K]);
    }
}