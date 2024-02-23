import java.util.*;

class Solution {
    public int[] solution(int[][] dice) {
        int[] answer = {};
        
        // 절반만 계산하면 나머지 나머지도 계산 가능
        int n = dice.length / 2;

        List<List<Integer>> comb = new ArrayList<List<Integer>>();
        List<List<Integer>> remain = new ArrayList<List<Integer>>();

        calcComb(comb, remain, new ArrayList<>(), n, 0, dice.length);

        int winCount =0;
        
        //각 조합 마다의 승 수를 확인하고 더 승수가 높은 경우의 주사위 조합을 answer에 담음
        for(int i=0; i<comb.size(); i++){
            List<Integer> s = comb.get(i);
            List<Integer> r = remain.get(i);
            int newCount = winCount(dice, s, r);
            if(winCount < newCount){
                winCount = newCount;
                answer = new int[s.size()];
                for(int j=0; j<s.size(); j++){
                    answer[j] = s.get(j)+1;
                }
            }

        }

        return answer;
    }
    
    // 주사위를 나눠 같는 경우를 조합하여 list에 넣음
    private void calcComb(List<List<Integer>> comb, List<List<Integer>> remain, List<Integer> current, int n, int start, int len) {
        if(current.size() == n) {
            comb.add(new ArrayList<>(current));

            List<Integer> tmp = new ArrayList<>();
            for(int i=0; i<len; i++) {
                if(!current.contains(i)) {
                    tmp.add(i);
                }
            }
            remain.add(tmp);
        } else {
            for(int i=start; i<len; i++) {
                current.add(i);
                calcComb(comb, remain, current, n, i+1, len);
                current.remove(current.size()-1);
            }
        }
    }
    
    //이분 탐색 메소드
    //이분 탐색을 이용해서 특정 숫자보다 큰 경우의 수를 구함
    //list에는 상대의 주사위 합 경우의수를 담고 target에는 자신의 주사위 합 중에 하나의 값을 넣어 기준으로 사용
    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
    
    //모든 경우의 합을 담을 배열 sums를 생성하고 계산하는 메소드로 넘김
    //이후에 sums를 반환
    private List<Integer> calculateSums(int[][] dices, List<Integer> indices) {

        List<Integer> sums = new ArrayList<>();
        calculateSumsRecursive(dices, indices, 0, 0, sums);
        return sums;
    }
    
    //각 주사위를 통해서 나올 수 있는 경우의 합을 sums에 넣음 => 모든 경우의 합이 sums에 들어감
    private void calculateSumsRecursive(int[][] dices, List<Integer> indices, int index, int currentSum, List<Integer> sums) {
        if (index == indices.size()) {
            sums.add(currentSum);
            return;
        }

        int diceIndex = indices.get(index);
        for (int i = 0; i < dices[diceIndex].length; i++) {
            calculateSumsRecursive(dices, indices, index + 1, currentSum + dices[diceIndex][i], sums);
        }
    }

    
    private int winCount(int[][] dice, List<Integer> selected, List<Integer> remain){
        int winCount = 0;
        
        //A와 B가 선택한 주사위에서 나올 수 있는 모든 경우의 합을 각 List에 담음
        List<Integer> selectedSums = calculateSums(dice, selected);
        List<Integer> remainingSums = calculateSums(dice, remain);
        
        //BinarySerch를 이용하기 위한 힙 정렬
        Collections.sort(selectedSums);
        Collections.sort(remainingSums);

        //selectedSums를 기준으로 remainingSums의 요소들과 비교 승 수를 count
        for(int selectedNum : selectedSums){
            int winIndex = binarySearch(remainingSums, selectedNum);
            winCount += winIndex;
        }
        
        //winCount 반환
        return winCount;
    }
}
