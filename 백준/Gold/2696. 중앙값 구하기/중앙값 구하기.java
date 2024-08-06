import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb;
        
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++) {
            sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for(int i = 0; i < N; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int num = Integer.parseInt(st.nextToken());

                if(maxHeap.size() == minHeap.size())
                    maxHeap.offer(num);
                else
                    minHeap.offer(num);

                if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(minHeap.poll());
                }

                if(i % 2 == 0)
                    sb.append(maxHeap.peek()).append(" ");
            }

            System.out.println(N / 2 + 1);
            System.out.println(sb);
        }
    }
}