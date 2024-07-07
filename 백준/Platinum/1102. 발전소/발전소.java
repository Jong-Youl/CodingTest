import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int inf = 987654321;
    private static int N, target;
    private static int [][] dp;
    private static int [][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int isOn = 0, bit = 0;

        cost = new int [N + 1][N + 1];
        dp = new int [N + 1][1 << N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], inf);
        }
        String str = br.readLine();
        for(int i = 0; i < N; i++) {
            if(str.charAt(i) == 'Y') {
                bit = bit | (1 << i);
                isOn++;
            }
        }

        target = Integer.parseInt(br.readLine());
        int result = repair(isOn, bit);

        System.out.println(result == inf? -1:result);
    }

    private static int repair(int isOn, int bit) {
        if(isOn >= target)
            return 0;
        if(dp[isOn][bit] != inf)
            return dp[isOn][bit];

        for(int i = 0; i < N; i++) {
            if((bit & (1 << i)) != 0) {
                for(int j = 0; j < N; j++) {
                    if(i == j) continue;
                    if((bit & (1 << j)) == 0)
                        dp[isOn][bit] = Math.min(dp[isOn][bit], repair(isOn + 1, bit | (1 << j)) + cost[i][j]);
                }
            }
        }
        return dp[isOn][bit];
    }
}