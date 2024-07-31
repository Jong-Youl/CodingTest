import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] jewel = new int [N][2];
        int [] bag = new int [K];
        int [] dp = new int [1_000_001];

        // 300,000개 무게 기준으로 정렬 필요함
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        // 300,000개 작은순으로 정렬 필요함
        for(int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewel, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o2[1] - o1[1];
                else
                    return o1[0] - o2[0];
            }
        });

        Arrays.sort(bag);

        //가격 내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0L;
        // 가방마다 확인하기
        int j = 0;
        for(int i = 0; i < K; i++) {
            //나보다 작은 무게 전부 pq에 때려넣음
            while(j < N && jewel[j][0] <= bag[i])
                pq.add(jewel[j++][1]);

            //가장 우선순위 높은 요소가 가장 Value가 높은 물건임
            if(!pq.isEmpty())
                result += pq.poll();
        }

        System.out.println(result);
    }
}