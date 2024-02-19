import java.util.Arrays;

class Solution{
    
    public int solution(int []A, int []B){
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[A.length - 1 - i];
        }
        
        return answer;
    }
    
    public void sort (int[] arr, String order){
        if(order.equals("asc")) {
            for(int i = 0; i < arr.length-1; i++){
                for(int j = i; j < arr.length-1; j++){
                    //오름차순 뒤에가 더 작으면 바꿔줌
                    if(arr[j] > arr[j + 1]){
                        int tmp = arr[j+1];
                        arr[j+1] = arr[j];
                        arr[j] = tmp;
                    }
                } 
            }
        }
        else {
            for(int i = 0; i < arr.length-1; i++){
                for(int j = i; j < arr.length-1; j++){
                    //내림차순 뒤에가 더 크면 바꿔줌
                    if(arr[j] < arr[j + 1]){
                        int tmp = arr[j+1];
                        arr[j+1] = arr[j];
                        arr[j] = tmp;
                    }
                } 
            }
        }
    }
}