import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            // 여는 괄호가 나올 땐 그냥 넣는다.
            if(tmp == '(') stack.add(tmp);
            else {
                // 스택에 쌓인 괄호가 없는데 닫는 괄호가 나온다면 -> 실패 
                if(stack.size() == 0) return answer;
                // 스택에 쌓인 괄호가 있다.
                else{
                    // 그런데 가장 마지막에 쌓인 괄호가 닫는 괄호라면 -> 실패
                    if(stack.peek() == ')') return answer;
                    // 여는 괄호라면
                    else stack.pop();
                }
            }
        }
        // 저 지옥의 for문 if문을 빠져나왔다면 스택엔 아무것도 없어야함
        
        if(stack.size() == 0) return true;
        else return answer;
            
    }
}