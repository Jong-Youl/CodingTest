import java.util.*;

class Solution {
    
    class GameInfo implements Comparable<GameInfo> {
        int stage;
        float p;
        
        GameInfo(int stage, float p) {
            this.stage = stage;
            this.p = p;
        }
        
        @Override
        public int compareTo(GameInfo g) {
            return Float.compare(g.p, this.p);
        }
    }
    
     public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        GameInfo[] result = new GameInfo[N];

        int[] sCnts = new int[N + 2];
        for (int stage : stages)
            sCnts[stage]++;

        int pCnt = stages.length;
        for (int i = 1; i <= N; i++) {
            if (pCnt == 0) {
                result[i - 1] = new GameInfo(i, 0);
            } else {
                float failRate = (float) sCnts[i] / pCnt;
                result[i - 1] = new GameInfo(i, failRate);
                pCnt -= sCnts[i];
            }
        }

        Arrays.sort(result);

        for (int i = 0; i < N; i++) {
            answer[i] = result[i].stage;
        }

        return answer;
    }
}