class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String [] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int [] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int curr = 0;
        for(int i = 0; i < a; i++)
            curr += month[i];
        curr += b;
        
        return days[curr % 7];
        }
}