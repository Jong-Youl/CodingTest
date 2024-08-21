import java.util.Scanner;

public class Main {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int cnt = 1;
        int [] color = new int [N + 1];

        color[1] = 1;
        sb.append(color[1]).append(" ");
        for(int i = 2; i <= N; i++) {
            if(color[i] == 0) {
                cnt++;
                int nextIdx = 1;
                while(nextIdx * i <= N) {
                    color[nextIdx * i] = cnt;
                    nextIdx++;
                }
            }
            sb.append(color[i]).append(" ");
        }

        System.out.println(cnt);
        System.out.println(sb);
    }

}