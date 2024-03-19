import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int valExt, String sortBy) {
        String [] features = {"code", "date", "maximum", "remain"};
        
        List<int[]> dummy = new ArrayList<>();
        
        int extIdx = 0;
        int sortIdx = 0;
        //ext 값이 val_ext보다 작은 데이터만
        //sort_by 기준으로 오름차순
        for(int i = 0; i < features.length; i++) {
            if(features[i].equals(ext)) {
                extIdx = i;
            }
            if(features[i].equals(sortBy)) {
                sortIdx = i;
            }
        }
        
        for(int [] tmp : data) {
            if(tmp[extIdx] < valExt) {
                dummy.add(tmp);
            }
        }
                
        int[][] answer = new int [dummy.size()][4];
        
        for(int i = 0; i < dummy.size(); i++) {
            answer[i] = dummy.get(i);
        }
        
        final int key = sortIdx ;
        
        Arrays.sort(answer, (o1, o2) -> o1[key] - o2[key]);
        
        return answer;
    }
}