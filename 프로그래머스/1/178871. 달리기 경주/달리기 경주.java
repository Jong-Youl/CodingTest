import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String [players.length];
        
        // 자기 바로 앞 선수를 추월할 때 추월자의 이름 호명
        // players 50,000, 중복 X
        // callings 1,000,000
        
        // callings 를 확인하고 찾아서 고치는 속도 -> 1,000,000 * 50,000
        // hashMap 사용
        // key = 이름, value = 현재 등수
        Map <String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++) {
            // 불렸다면 찾아서 확인
            String winner = callings[i];
            int idx = map.get(winner);
            String looser = players[idx - 1];
            // 배열 내부에서 교체
            players[idx - 1] = winner;
            players[idx] = looser;
            // map에서 교체
            map.put(looser, idx);
            map.put(winner, idx - 1);
        }
                
        return players;
    }
}