import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long[] sum1;
    static long[] sum2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        long[] B = new long[N];
        long[] C = new long[N];
        long[] D = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        sum1 = new long[N * N];
        sum2 = new long[N * N];

        // N ^ 2
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum1[idx] = A[i] + B[j];
                sum2[idx++] = C[i] + D[j];
            }
        }

        Arrays.sort(sum1);
        Arrays.sort(sum2);

        long result = 0;

        for (int i = 0; i < sum1.length; i++) {
            long target = -sum1[i];
            int lower = lowerBound(target);
            int upper = upperBound(target);
            result += (upper - lower);
        }

        System.out.println(result);
    }

    private static int lowerBound(long target) {
        int low = 0;
        int high = sum2.length;

        while(low < high) {
          int mid = (low + high) / 2;
          if(sum2[mid] < target) {
              low = mid + 1;
          }
          else {
              high = mid;
          }
        }
        return low;
    }

    private static int upperBound(long target) {
        int low = 0;
        int high = sum2.length;

        while(low < high) {
            int mid = (low + high) / 2;
            if(sum2[mid] <= target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
//    최악의 경우 o(n^4) 가 나올 수 있음
//    private static int binaryCntSearch(int upDown, int start, int end, long target) {
//        int cnt = 0;
//        int mid = start + (end - start) / 2;
//
//        if (start > end) return 0;
//
//        if (target == sum2[mid]) {
//            cnt++;
//            cnt += checkSameValue(upDown, mid);
//        }
//        else if (target < sum2[mid])
//            cnt += binaryCntSearch(-1, start, mid - 1, target);
//        else
//            cnt += binaryCntSearch(1, mid + 1, end, target);
//        return cnt;
//    }
//
//    private static int checkSameValue(int upDown, int mid) {
//        int idx = 1;
//        int cnt = 0;
//        if(upDown == 1) {
//            while (mid + idx < sum2.length) {
//                if(sum2[mid + idx] == sum2[mid]) cnt++;
//                else break;
//                idx++;
//            }
//        }
//        else {
//            while (mid - idx > -1) {
//                if(sum2[mid - idx] == sum2[mid]) cnt++;
//                else break;
//                idx++;
//            }
//        }
//
//        return cnt;
//    }

    private static void mergeSort(int start, int end, long[] arr) {
        int mid = (start + end) / 2;
        if (end - start > 1) {
            mergeSort(start, mid, arr);
            mergeSort(mid, end, arr);
        }
        int idx = 0;
        int leftIdx = start;
        int rightIdx = mid;

        long[] tmp = new long[end - start];

        while (leftIdx < mid && rightIdx < end) {
            if (arr[leftIdx] <= arr[rightIdx])
                tmp[idx++] = arr[leftIdx++];
            else
                tmp[idx++] = arr[rightIdx++];
        }

        while (leftIdx < mid) {
            tmp[idx++] = arr[leftIdx++];
        }
        while (rightIdx < end) {
            tmp[idx++] = arr[rightIdx++];
        }

        for (int i = 0; i < tmp.length; i++) {
            arr[start + i] = tmp[i];
        }
    }
}