import java.util.Scanner;

public class Main {
    private static final int modNum = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[][][] dp = new long[N + 1][11][1 << 10];

        for(int i=1; i<10; i++) {
            dp[1][i][1<<i] =1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    int bit = k | (1 << j);
                    if (j == 0)
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % modNum;
                    else if (j == 9)
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % modNum;
                    else
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k] + dp[i - 1][j - 1][k]) % modNum;
                }
            }
        }

        long sum = 0L;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N][i][1023]) % modNum;
        }

        System.out.println(sum);
    }
}