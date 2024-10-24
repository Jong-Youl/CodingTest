import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder result = new StringBuilder();

        while(A != 0) {
            // A -> 이웃의 사용량과 사용량을 합쳤을 때 내야하는 요금 a + b
            // totalWH -> 총 사용량
            // B -> 이웃의 전기 요금과의 차이(절댓값) |a - b|
            // diffWH => 사용량 차이
            // (totalWH - diffWH) / 2 -> 내 사용량

            int totalWH = getSpentWH(A);
            int left = 0;
            int right = totalWH / 2;

            while(left <= right) {
                int mid = (left + right) / 2;

                int sPrice = getCostPW(mid);
                int nPrice = getCostPW(totalWH - mid);
                int diff = Math.abs(sPrice - nPrice);
                if(diff < B)
                    right = mid - 1;
                else if (diff > B)
                    left = mid + 1;
                else {
                    result.append(getCostPW(mid)).append("\n");
                    break;
                }
            }


            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
        }

        System.out.println(result);
    }
    private static int getSpentWH(int cost) {
        /*
        *   200원
        *   30000 - 300 + 200원 -> 29900
        *   (5000000 - 50000 + (30000 - 300 + 200)) -> 5000000 - 20100
        *   그 이상
        * */
        int WH = 0;

        if(cost > (5000000 - 50000 + (30000 - 300 + 200))) {
            //초과분 / 7
            WH += (cost - (5000000 - 50000 + (30000 - 300 + 200))) / 7;
            WH += 1000000;
        }
        else if (cost > (30000 - 300 + 200)) {
            WH += (cost - (30000 - 300 + 200)) / 5;
            WH += 10000;
        }
        else if (cost > 200) {
            WH += (cost - 200) / 3;
            WH += 100;
        }
        else {
            WH += cost / 2;
        }

        return WH;
    }
    private static int getCostPW(int wattHour) {
        int cost = 0;

        while (wattHour > 0) {
            if(wattHour > 1000000) {
                cost += 7 * (wattHour - 1000000);
                wattHour = 1000000;
            }
            else if (wattHour > 10000) {
                cost += 5 * (wattHour - 10000);
                wattHour = 10000;
            }
            else if (wattHour > 100) {
                cost += 3 * (wattHour - 100);
                wattHour = 100;
            }
            else {
                cost += 2 * wattHour;
                wattHour = 0;
            }
        }

        return cost;
    }
}