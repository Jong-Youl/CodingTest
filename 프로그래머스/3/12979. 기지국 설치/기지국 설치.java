class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int start = 1;
        
        for (int station : stations) {
            int left = station - w;
            int right = station + w;

            // 현재 station이 커버하지 못한 왼쪽 구간에 대해 계산
            if (start < left) {
                int length = left - start;
                answer += length / coverage;
                if(length % coverage > 0)
                    answer++;
            }

            // 다음 시작 지점을 현재 기지국 오른쪽 다음 칸으로 이동
            start = right + 1;
        }

        // 마지막 기지국 이후 남은 구간 처리
        if (start <= n) {
            int length = n - start + 1;
            answer += length / coverage;
            
            if(length % coverage > 0)
                answer++;
        }

        return answer;
    }
}
