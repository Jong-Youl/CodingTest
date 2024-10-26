import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        // 공유기 설치 대 수 : C개
        // 공유기 사이의 거리를 가능한 크게
        int [] homes = new int [N];

        for(int i = 0; i < N; i++) {
            homes[i] = sc.nextInt();
        }

        Arrays.sort(homes);
        // 어떻게 해야하는가?
        int left = 1;
        int right = homes[N-1] - homes[0];

        while(left <= right) {
            int mid = (left + right) / 2;

            // 원하는 만큼 공유기를 설치할 수 없다면
            if(isValid(mid, homes) >= C) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(left - 1);
    }

    private static int isValid(int target, int [] homes) {
        int count = 1;

        int start = homes[0];

        for(int i = 1; i < homes.length; i++) {
            if(homes[i] - start >= target) {
                count++;
                start = homes[i];
            }
        }

        return count;
    }
}