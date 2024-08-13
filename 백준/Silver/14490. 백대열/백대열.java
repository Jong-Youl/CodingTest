import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String [] str = br.readLine().split(":");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int min = Math.min(n, m);

        if(n % m != 0) {
            int rn = n, rm = m;
            for(int i = 2; i <= min; i++) {
                if(n % i == 0 && m % i == 0) {
                    rn = n/i;
                    rm = m/i;
                }
            }
            sb.append(rn).append(":").append(rm);
        }
        else
            sb.append(n/min).append(":").append(m/min);

        System.out.print(sb);
    }
}