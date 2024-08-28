import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length(); i++) {
            char tmp = a.charAt(i);
            int diff = 'a' - 'A';
            if(tmp > 'Z')
                tmp -= diff;
            else if(tmp < 'z')
                tmp += diff; 
            
            sb.append(tmp);    
        }
        System.out.println(sb.toString());
    }
}