import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int [] arr = new int [N];
        
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        
        int num = sc.nextInt();
        
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(arr[i] == num)
                cnt++;
        }
        sc.close();
        System.out.print(cnt);
    }
}