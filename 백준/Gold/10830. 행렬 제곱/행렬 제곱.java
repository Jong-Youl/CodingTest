import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int [][] arr = new int [N][N];
        int [][] result;

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        result = getResult(arr, B);

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                sb.append(result[r][c]). append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] getResult(int [][] arr, long cnt) {
        if(cnt == 1) {
            return arr;
        }

        int [][] result = getResult(arr, cnt/2);
        result = timeArrays(result, result);

        if(cnt % 2 == 1) {
            result = timeArrays(result, arr);
        }

        return result;
    }


    private static int [][] timeArrays(int[][] arr1, int[][] arr2) {
        int idx1, idx2, sum;
        int [][] result = new int [arr1.length][arr1.length];

        for(int r = 0; r < arr1.length; r++){
            for(int c = 0; c < arr1[0].length; c++){
                idx1 = 0;
                idx2 = 0;
                sum = 0;
                while(idx1 != arr1.length && idx2 != arr1.length) {
                    sum += arr1[r][idx1++] * arr2[idx2++][c];
                }
                result[r][c] = sum % 1000;
            }
        }
        return result;
    }
}