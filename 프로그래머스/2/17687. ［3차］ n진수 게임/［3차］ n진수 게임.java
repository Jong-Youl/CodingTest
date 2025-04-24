import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        List<Character> seq = new ArrayList<>();
        int num = 0;

        while (seq.size() < t * m) {
            String curr = Integer.toString(num++, n).toUpperCase();
            for (char ch : curr.toCharArray()) {
                seq.add(ch);
            }
        }

        for (int i = 0; i < t; i++) {
            answer.append(seq.get(i * m + (p - 1)));
        }

        return answer.toString();
    }
}
