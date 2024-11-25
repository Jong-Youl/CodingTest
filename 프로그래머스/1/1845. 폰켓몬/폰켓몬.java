import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int phoneketmon : nums) {
            set.add(phoneketmon);
        }
        
        return (set.size() > (nums.length / 2)) ? (nums.length / 2) : set.size();
    }
}