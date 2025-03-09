class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        /*
            콜라 빈 병 2개 => 콜라 1병
            보유 중인 빈 병이 2개 미만이면 콜라를 받을 수 없음
            빈 병 20개는 몇 병을 받을 수 있는가??
        */
        
        while(n >= a) {
            int tmp = n / a;
            n %= a;
            n += tmp * b;
            answer += tmp * b;
        }
        
        
        return answer;
    }
}

/*
    20 3 1
    18 6 -> 2
    8
*/