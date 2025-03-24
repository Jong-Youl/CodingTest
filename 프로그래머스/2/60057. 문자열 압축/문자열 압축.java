class Solution {
    public int solution(String s) {
        int len = s.length();
        int min = len;
        
        for (int bind = 1; bind <= len / 2; bind++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, bind);
            int count = 1;

            for (int i = bind; i <= len - bind; i += bind) {
                String curr = s.substring(i, i + bind);
                if (prev.equals(curr))
                    count++;
                else {
                    if (count > 1) 
                        sb.append(count);
                    
                    sb.append(prev);
                    prev = curr;
                    count = 1;
                }
            }

            if (count > 1) 
                sb.append(count);
            sb.append(prev);

            if (len % bind != 0) 
                sb.append(s.substring(len - len % bind));

            min = Math.min(min, sb.length());
        }

        return min;
    }
}