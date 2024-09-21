import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 정렬
        // 음수가 섞임
        cnt = 0;
        mergeSort(arr, 0, arr.length);
        
        for (int i = 0; i < N; i++) {
            int target = arr[i];
            int left = 0, right = N - 1;

            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];
                if (sum == target) {
                    cnt++;
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(cnt);
    }

    private static void binarySearch(int [] arr, int start, int end, int target) {
        int mid = (start + end) / 2;

        if(start >= end) return;

        if(arr[mid] == target) {
            int idx = 0;
            // mid 주변의 값이 Target이랑 같을수록 cnt++;
        }
        else if(arr[mid] < target)
            binarySearch(arr, start, mid, target);
        else
            binarySearch(arr, mid, end, target);
    }

    private static void mergeSort(int [] arr, int start, int end) {
        int mid = (start + end) / 2;

        if(start + 1 >= end) return;
        
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        
        int [] dummy = new int [end - start];

        int idx = 0, idx1 = start, idx2 = mid;

        while(idx1 < mid && idx2 < end) {
            if(arr[idx1] <= arr[idx2])
                dummy[idx++] = arr[idx1++];
            else
                dummy[idx++] = arr[idx2++];
        }

        while (idx1 < mid) {
            dummy[idx++] = arr[idx1++];
        }
        while(idx2 < end) {
            dummy[idx++] = arr[idx2++];
        }

        for(int i = 0; i < dummy.length; i++) {
            arr[start + i] = dummy[i];
        }
    }
}