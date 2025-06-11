import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int size = numbers.length;
        String [] strNum = new String [size];
        
        for(int i = 0; i < size; i++)
            strNum[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(strNum, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder sb = new StringBuilder();
        for(String str : strNum)
            sb.append(str);
        
        // 전체가 0이지만 문자열로 0이 n번 적힌 값으로 표현될 경우를 피하기 위해
        if (strNum[0].equals("0")) {
            return "0";
        }
        
        return sb.toString();
    }
}