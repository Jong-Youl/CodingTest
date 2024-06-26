import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int [][] map = new int [str1.length + 1][str2.length + 1];
        int result = 0;

        for(int r = 1; r <= str1.length; r++) {
            for(int c = 1; c <= str2.length; c++) {
                if(str1[r-1] == str2[c-1]) map[r][c] = map[r - 1][c - 1] + 1;
                else map[r][c] = Math.max(map[r-1][c] , map[r][c-1]);
                result = Math.max(result, map[r][c]);
            }
        }

        System.out.println(result);
    }
}