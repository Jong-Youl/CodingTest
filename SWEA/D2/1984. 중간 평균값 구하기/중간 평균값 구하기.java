import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int N = 10;// 테스트마다 10개 숫자
        int t = sc.nextInt();// 테스트 횟수
 
        for (int tc = 1; tc <= t; tc++) {
            int[] arr = new int[N];
            float cnt = 0;// 결과
            int res = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
 
            // 버블 정렬을 이용
            for (int i = 0; i < N - 1; i++) {
                for (int j = 1; j < N - i; j++) {
                    if (arr[j - 1] > arr[j]) {// 앞선 값이 뒤에 값보다 크다면 위치 변환
                        int temp = arr[j - 1];// 대체 변수
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
 
            for (int i=1; i < N-1; i++) {
                cnt += arr[i];
            }
            res = Math.round(cnt/(N-2));
             
            System.out.println("#" + tc + " " + res);
        }
    }
}