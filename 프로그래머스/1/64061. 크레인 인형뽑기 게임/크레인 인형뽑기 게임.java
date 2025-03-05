import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack <Integer> stack = new Stack<>();
        
        for(int move : moves) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][move - 1] != 0) {
                    answer += checkStack(stack, board[i][move - 1]);
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public int checkStack(Stack<Integer> stack, int target) {
        // 하나씩 쌓고 들어가기 때문에 연속으로 터지는 경우는 없음
        int result;
        if(!stack.isEmpty() && stack.peek() == target) {
            stack.pop();
            result = 2;
        }
        else {
            stack.add(target);
            result = 0;
        }
        
        return result;
    }
}