import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static boolean isFinished = false;
    private static int N;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        //N은 최대 80
        N = sc.nextInt();
        arr = new int[N];
        //depth, tmpValue
        dfs(0);
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            isFinished = true;
            return;
        }


        for (int i = 1; i <= 3; i++) {
            arr[depth] = i;
            if (depth > 0 && checkDuplication(depth)) continue;
            dfs(depth + 1);
            if (isFinished) return;
        }
    }

    // 중복이면 True, 중복이 아니면 False
    private static boolean checkDuplication(int depth) {
        int left, right, cnt = 1;
        boolean r;
        while (cnt <= (depth / 2) + 1) {
            r = true;
            left = depth - cnt;
            right = depth;

            for (int i = 0; i < cnt; i++) {
                if(left - i < 0) {
                    r = false;
                    continue;
                }
                if (arr[right - i] != arr[left - i]) {
                    r = false;
                    break;
                }
            }
            if (r)
                return r;
            else
                cnt++;
        }
        return false;
    }
}