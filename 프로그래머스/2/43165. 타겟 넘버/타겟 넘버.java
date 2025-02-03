class Solution {
    public int answer = 0;
    public int solution(int[] numbers, int target) {
        // 덧셈 or 뺄셈      
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    public void dfs (int depth, int sum, int [] nums, int target) {
        if (depth == nums.length) {
            if(sum == target) {
                answer++;             
            }
            return;
        }
        
        dfs(depth + 1, sum + nums[depth], nums, target);
        dfs(depth + 1, sum - nums[depth], nums, target);
    }
}