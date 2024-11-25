import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> cMap = new HashMap<>();
        
        // 각 의상 종류별 개수를 맵에 저장
        for (String[] cloth : clothes) {
            cMap.put(cloth[1], cMap.getOrDefault(cloth[1], 0) + 1);
        }
        
        int combinations = 1;
        
        // 각 카테고리에서 (의상 수 + 1(선택하지 않는 경우))를 곱함
        for (int count : cMap.values()) {
            combinations *= (count + 1);
        }
        
        // 최소 한 개는 입어야 하므로 아무것도 입지 않는 경우를 제외
        return combinations - 1;
    }
}
