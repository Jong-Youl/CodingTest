import java.util.*;

class Solution {
    class MusicInfo implements Comparable <MusicInfo>{
        int idx, agg;
        
        MusicInfo(int idx, int agg) {
            this.idx = idx;
            this.agg = agg;
        }
        
        @Override
        public int compareTo(MusicInfo m) {
            if(m.agg == this.agg)
                return this.idx - m.idx;
            return m.agg - this.agg;
        }
    }
    
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playlist = new HashMap<>();      
        Map<String, List<MusicInfo>> totalMap = new HashMap<>();
        
        // 만 번
        for(int i = 0; i < genres.length; i++) {
            playlist.put(genres[i], playlist.getOrDefault(genres[i], 0) + plays[i]);
            totalMap.putIfAbsent(genres[i], new ArrayList<>());
            totalMap.get(genres[i]).add(new MusicInfo(i, plays[i]));
        }
        
        // 재생 횟수로 정렬
        List<Integer> result = new ArrayList<>();
        List<String> sortedGenres = new ArrayList<>(playlist.keySet());
        sortedGenres.sort((a, b) -> playlist.get(b) - playlist.get(a));

        for (String genre : sortedGenres) {
            List<MusicInfo> curr = totalMap.get(genre);
            Collections.sort(curr);
            for (int i = 0; i < Math.min(2, curr.size()); i++) {
                result.add(curr.get(i).idx);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}