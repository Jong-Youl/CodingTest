import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // target이 words에 없으면 변환이 불가능하므로 0을 바로 반환
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        // BFS를 위한 큐 선언
        Queue<String> queue = new LinkedList<>();
        // 큐에는 단어와 그 단어로 가기 위한 단계수를 함께 저장
        queue.offer(begin);
        int steps = 0;

        // 방문 체크 배열
        boolean[] visited = new boolean[words.length];

        // BFS 시작
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            // 큐에 있는 모든 단어를 한 단계씩 처리
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // 모든 words 배열을 돌면서 변환 가능한 단어를 큐에 추가
                for (int j = 0; j < words.length; j++) {
                    // 이미 방문한 단어는 건너뛰기
                    if (visited[j]) continue;

                    // 한 글자만 다르면 변환 가능
                    if (isOneCharDiff(current, words[j])) {
                        if (words[j].equals(target)) {
                            return steps;  // target에 도달하면 그 단계 수를 반환
                        }
                        queue.offer(words[j]);  // 변환 가능한 단어 큐에 추가
                        visited[j] = true;  // 방문 처리
                    }
                }
            }
        }
        
        return 0;  // 큐를 다 돌아도 target을 찾지 못하면 변환 불가능
    }

    // 두 단어가 한 글자만 다른지 확인하는 함수
    private boolean isOneCharDiff(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        return diffCount == 1;
    }
}
