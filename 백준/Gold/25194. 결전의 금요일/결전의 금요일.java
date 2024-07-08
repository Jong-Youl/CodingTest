import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [] day = new int [N];
        int [] dp = new int [7];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            day[i] = Integer.parseInt(st.nextToken()) % 7;
        }

        dp[0] = 1;
        for(int i = 0; i < N; i++) {
            int [] tmp = new int [7];
            for(int j = 0; j < 7; j++) {
                if(dp[j] > 0){
                    tmp[(day[i] + j) % 7]++;
                }
            }

            for(int j = 0; j < 7; j++) {
                dp[j] += tmp[j];
            }
        }

        if(dp[4] != 0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}