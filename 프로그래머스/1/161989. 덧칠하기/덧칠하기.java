class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        /*
            한 번에 m 만큼 칠할 수 있음
            칠해야 하는 곳은 section에 담겨있음
        */
        
        int curr = 1;
        
        for(int num : section) {
            if(curr <= num) {
                answer++;
                curr = num + m;
            }
        }
        
        
        return answer;
    }
}