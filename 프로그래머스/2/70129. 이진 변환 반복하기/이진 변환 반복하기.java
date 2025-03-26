class Solution {
    public int[] solution(String s) {
        int[] answer = new int [2];
        
        while(!s.equals("1")) {
            StringBuilder sb = new StringBuilder();
            // 0 제거
            for(int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);
                if(curr != '0')
                    sb.append(curr);
                else
                    answer[1]++;
            }
            
            // 자리수로 2진수 만들기
            s = Integer.toString(sb.length(), 2);
            answer[0]++;
        }

        return answer;
    }
}