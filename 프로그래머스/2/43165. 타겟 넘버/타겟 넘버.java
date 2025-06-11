class Solution {
    public int answer = 0;
    public int solution(int[] numbers, int target) {
        // 더하거나 빼서 타겟 넘버를 만들것
        // 덧셈 뺄셈은 숫자를 바꿔도 같음
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public void dfs(int [] numbers, int depth, int sum, int target) {
        if(depth == numbers.length) {
            if(sum == target)
                answer++;
            
            return;
        }
        
        dfs(numbers, depth + 1, sum + numbers[depth], target);
        dfs(numbers, depth + 1, sum - numbers[depth], target);
    }
}