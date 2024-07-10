import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int totalValue;
    private static int[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 0; tc < 3; tc++) {
            int N = Integer.parseInt(br.readLine());

            totalValue = 0;
            value = new int[100_001];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int coin = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());

                checkValue(coin, cnt);
                for (int j = 1; j <= cnt; j++)
                    value[coin * j]++;
                totalValue += (coin * cnt);
            }
            if (totalValue % 2 != 0) sb.append(0).append("\n");
            else sb.append(value[totalValue / 2] != 0 ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }

    private static void checkValue(int coin, int cnt) {
        for (int i = totalValue; i > 0; i--) {
            if (value[i] == 0) continue;
            for (int j = 1; j <= cnt; j++) {
                if (i + (coin * j) > 100_000) break;
                value[i + (coin * j)]++;
            }
        }
    }
}
