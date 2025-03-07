import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int num : ingredient) {
            // 빵 나오면 지금까지 빵 - 야채 - 고기 순으로 나왔는지 확인
            if (num == 1 && stack.size() >= 3) {
                if (checkStack(stack))
                    answer++;
                else
                    stack.add(num);
            }
            else
                stack.add(num);
        }
        
        return answer;
    }
    
    public boolean checkStack(Stack<Integer> stack) {
        int[] dummy = new int[3];
        boolean result = true;
        int idx = 2;
        int target = 3;

        // 3 -> 2 -> 1 순으로 나와야 함
        while (idx >= 0) {
            if (stack.peek() == target) {
                dummy[idx] = stack.pop();
                idx--;
                target--;
            } else {
                for (int i = idx + 1; i < 3; i++) {
                    stack.add(dummy[i]);
                }
                result = false;
                break;
            }
        }
        
        return result;
    }
}
