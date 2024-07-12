import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<int[]> items = new ArrayList<>();
        items.add(new int[]{0, 0});        // index를 1부터 하기 위해 null값 하나 추가
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());   // 물건의 무게
            int c = Integer.parseInt(st.nextToken());   // 물건의 가치
            int k = Integer.parseInt(st.nextToken());   // 물건의 개수

            int tempK = 1;
            //거듭제곱 분할
            while (tempK <= k) {
                items.add(new int[]{tempK * v, tempK * c});
                k -= tempK;
                tempK *= 2; 
            }
            if (k != 0) {
                items.add(new int[]{k * v, k * c});
            }
        }

        int[][] dp = new int[items.size() + 1][m + 1];
        for (int i = 1; i < items.size(); i++) {
            for (int j = 1; j <= m; j++) {
                if (j < items.get(i)[0]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items.get(i)[0]] + items.get(i)[1]);
                }
            }
        }
        System.out.println(dp[items.size() - 1][m]);
    }
}