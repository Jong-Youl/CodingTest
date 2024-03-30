import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> lst = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(lst.size() == 0){
                lst.add(arr[i]);
            }
            else if(arr[i] == lst.get(lst.size()-1)){
                lst.remove(lst.size()-1);
            }
            else {
                lst.add(arr[i]);
            }
        }
        if(lst.size() == 0) {
            int [] answer = {-1};
            return answer;
        }
        else {
            int [] answer = new int [lst.size()];
            
            for(int i = 0; i < lst.size(); i++) {
                answer[i] = lst.get(i);
            }
            return answer;
        }
    }
}