import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int N = str1.length();
        int M = str2.length();
        int max = 0;

        int [][] dp = new int [N][M];

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(str1.charAt(r) == str2.charAt(c)) {
                    if(r >= 1 && c >= 1)
                        dp[r][c] = dp[r-1][c-1] + 1;
                    else
                        dp[r][c] = 1;

                    max = Math.max(max, dp[r][c]);
                }

            }
        }
        System.out.println(max);
    }
}