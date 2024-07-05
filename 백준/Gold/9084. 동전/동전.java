import java.io.*;
import java.util.*;

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N, M;
        int [] coin, dp;

        while(T > 0) {
            N = Integer.parseInt(br.readLine()); // 동전의 가지 수
            coin = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                coin[i] = Integer.parseInt(st.nextToken());

            M = Integer.parseInt(br.readLine());
            dp = new int[M + 1];
            dp[0] = 1;

            for(int i = 0; i < N; i++) {
                for(int j = 1; j <= M; j++) {
                    if(j - coin[i] >= 0)
                        dp[j] += dp[j - coin[i]];
                }
            }
            sb.append(dp[M]).append("\n");
            T--;
        }

        System.out.println(sb);
    }
}