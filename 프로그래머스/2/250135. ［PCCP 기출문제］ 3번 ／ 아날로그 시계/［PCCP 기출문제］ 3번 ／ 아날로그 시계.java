class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        int tmpSec = h1 * 60 * 60 + m1 * 60 + s1;
        int targetSec = h2 * 60 * 60 + m2 * 60 + s2;

        if(tmpSec == 0 || tmpSec == 43200) 
            answer++;
        
        // 시작부터 겹치는 경우 확인
        while (tmpSec < targetSec) {
            double tmpH = (h1 % 12) * 30 + m1 * 0.5 + s1 * (1.0 / 120);
            double tmpM = m1 * 6 + s1 * 0.1;
            double tmpS = s1 * 6.0;

            s1++;
            if (s1 == 60) {
                m1++;
                s1 = 0;
            }
            if (m1 == 60) {
                h1++;
                m1 = 0;
            }

            double nextH = (h1 % 12) * 30 + m1 * 0.5 + s1 * (1.0 / 120);
            double nextM = m1 * 6 + s1 * 0.1;
            double nextS = s1 * 6.0;

            // 시침과 초침의 겹침 확인
            if (tmpH > tmpS && nextH <= nextS) {
                answer++;
            } 
            else if (tmpS == 354 && tmpH > 354) {
                answer++;
            }

            // 분침과 초침의 겹침 확인
            if (tmpM > tmpS && nextM <= nextS) {
                answer++;
            } 
            else if (tmpS == 354 && tmpM > 354) {
                answer++;
            }

            // 시침과 분침이 초침과 동시에 겹칠 때 중복 제거
            if (Double.compare(nextH, nextM) == 0) {
                answer--;
            }

            tmpSec++;
        }

        return answer;
    }
}
