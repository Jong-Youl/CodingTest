import java.util.*;

public class Solution {
    private int maxDiff = 0;
    private int[] answer;

    public int[] solution(final int n, final int[] info) {
        answer = new int[] { -1 };
        int[] ryan = new int[11];
        dfs(n, info, ryan, 0);
        return answer;
    }

    private void dfs(final int score, final int[] apeach, int[] ryan, final int depth) {
        if (depth == 11) { // 모든 점수를 탐색한 경우
            if (score > 0) {
                ryan[10] += score; // 남은 화살은 0점에 모두 배치
            }
            int ryanScore = 0, apeachScore = 0;

            for (int i = 0; i < 11; i++) {
                if (ryan[i] > apeach[i]) {
                    ryanScore += 10 - i;
                } else if (apeach[i] > 0) {
                    apeachScore += 10 - i;
                }
            }

            int diff = ryanScore - apeachScore;
            if (diff > 0) {
                if (diff > maxDiff || (diff == maxDiff && isBetter(ryan))) {
                    maxDiff = diff;
                    answer = ryan.clone();
                }
            }
            if (score > 0) {
                ryan[10] -= score; // 백트래킹
            }
            return;
        }

        // 이번 점수를 이길 경우
        if (score > apeach[depth]) {
            ryan[depth] = apeach[depth] + 1;
            dfs(score - ryan[depth], apeach, ryan, depth + 1);
            ryan[depth] = 0; // 백트래킹
        }

        // 이번 점수를 포기할 경우
        dfs(score, apeach, ryan, depth + 1);
    }

    private boolean isBetter(final int[] curr) {
        // 낮은 점수부터 비교 (더 많은 화살을 맞힌 경우 우선)
        for (int i = 10; i >= 0; i--) {
            if (curr[i] != answer[i]) {
                return curr[i] > answer[i];
            }
        }
        return false;
    }
}
