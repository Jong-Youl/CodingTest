import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for (int tc = 1; tc <= 10; tc++) {//테스트 케이스 10개임
            int N = sc.nextInt();
             
            int[] arr = new int[N];// 1차원 배열로 층 정보만 받아가기
            int res = 0;
             
            for (int i = 0; i < N; i++) {//배열 입력
                arr[i] = sc.nextInt();
            }
 
            for (int i = 2; i < N-2; i ++) {// 양 옆 두칸 중 큰 거 고르기
                 
                int left = Math.max(arr[i-2], arr[i-1]);
                int right = Math.max(arr[i+2], arr[i+1]);
                 
                int max = Math.max(left, right);// 왼쪽이랑 오른쪽 중에 큰거
                 
                if(arr[i] > max) {//현재 건물이 +-2 위치의 건물들보다 크다면 res에 더해줌
                    res += (arr[i] - max); 
                }
            }
                         
            System.out.println("#" + tc + " " + res);
        }
    }
}