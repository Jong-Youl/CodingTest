class Solution {
    public int solution(int[] money) {
        int size = money.length;
        
        int [] first = new int [size + 1];
        int [] last = new int [size + 1];
        
        first[0] = 0;
        last[0] = 0;
        
        for(int i = 0; i < size - 1; i++) {
            first[i + 1] = money[i];
            last[i + 1] = money[i + 1];
        }
        
        for(int i = 2; i <= size; i++) {
            first[i] = Math.max(first[i - 1], first[i] + first[i - 2]);
            last[i] = Math.max(last[i - 1], last[i] + last[i - 2]);
        }
        
        return Math.max(first[size], last[size]);
    }
}