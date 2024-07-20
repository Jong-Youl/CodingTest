import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Integer target = Integer.parseInt(br.readLine());
        int start = 100;
        int min = Math.abs(target - start);
        int M = Integer.parseInt(br.readLine());

        boolean[] isOff = new boolean[10];

        if(M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                isOff[Integer.parseInt(st.nextToken())] = true;
            }
        }

        for(int i = 0; i < 1_000_000; i++) {
            String str = String.valueOf(i);
            boolean isPossible = true;

            for(int j = 0; j < str.length(); j++) {
                if(isOff[str.charAt(j) - '0']) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) {
                int cnt = str.length() + Math.abs(i - target);
                if(cnt < min)
                    min = cnt;
            }
        }

        System.out.println(min);
    }
}