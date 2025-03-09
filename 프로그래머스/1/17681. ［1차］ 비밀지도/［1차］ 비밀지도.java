class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String [] answer = new String[n];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            String map1 = toBinary(arr1[i], n);
            String map2 = toBinary(arr2[i], n);
            
            for(int j = 0; j < n; j++) {
                if(map1.charAt(j) == '0' && map2.charAt(j) == '0')
                    sb.append(' ');
                else
                    sb.append('#');
            }
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        
        return answer;
    }
    
    public String toBinary (int target, int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            int curr = (int) Math.pow(2, n - 1);
            
            if(target >= curr) {
                sb.append(1);
                target -= curr;
            }
            else
                sb.append(0);
            
            n--;
        }
        
        return sb.toString(); 
    }
}