import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		int [][][] dp = new int [n + 1][10][1 << 10];
		int modNum = 1_000_000_000;
		
		for(int i = 1; i < 10; i++) {
			// 첫 번쨰 자리에 1부터 9까지 시작하는 수를가정 동시에 어떤 수를 썼는지 체크
			dp[1][i][1 << i] = 1;
		}
		
		// 각 자리수마다 채우기
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < (1 << 10); k++) {
					// 현재 숫자를 bit에 기입 -> or 연산
					int bit = k | (1 << j);
					
					if (j == 0)
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % modNum;
                    else if (j == 9)
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % modNum;
                    else
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k] + dp[i - 1][j - 1][k]) % modNum;
				}
			}
		}
		
		long sum = 0L;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[n][i][1023]) % modNum;
        }

        System.out.println(sum);
	}
}