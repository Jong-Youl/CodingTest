import java.util.*;

class Solution {

    int n, finalRound, target, idx;
    int [] remain;
    List<Integer> using, additional;
    
    public int solution(int coin, int[] cards) {
        /*
        1. 카드 뭉치에서 카드 n/3장을 뽑음
        동전 수 : coin; 
        카드 뭉치 : 1~n 사이의 수 하나씩;
        */
        int answer = 0;
        
        //남은 숫자의 카드와 쓸 수 있는 숫자의 카드
        n = cards.length;
        remain = new int [n];
        using = new ArrayList<>();
        additional = new ArrayList<>();
        
        //타켓 숫자, 라운드 수
        target = n + 1;
        finalRound = 0;
        
        idx = cards.length / 3;
        
        //모든 수의 카드 추가
        for(int i = 0; i < n; i++){
            remain[i] = cards[i];
        }
        
        //뽑은 카드 제거 후 사용하는 카드 숫자에 추가
        for(int i = 0; i < idx; i++) {
            using.add(cards[i]);
        }
        
        while (true) {
            finalRound++;
            if(idx >= n) break;
            int paid = play(coin);
            
            if(paid == -1) break;
            
            coin -= paid;
            if(coin < 0) break;
        }
        
        answer = finalRound;
        
        return answer;
    }
    
    // 코인을 모두 쓰면 끝
    public int play(int coin) {
        //이번 라운드에 쓴 코인, 해결 된 상태인지
        int paid = 0;
        boolean isDone = false;
        
        for(int i : using) {
            //기존에 있는 숫자카드로 해결이 가능
            if(using.contains(target - i)) {
                //해당 숫자들 제거
                using.remove(Integer.valueOf(target - i));
                using.remove(Integer.valueOf(i));
                isDone = true;
                break;
            }
        }
        // 불가능
        // 뽑아야 한다
        if(idx+1 <= n){
            additional.add(remain[idx]);
            additional.add(remain[idx + 1]);
        
            idx += 2;        
        }
        
        if(!isDone){
            for(int i : using) {
                //1개로도 충분
                if(additional.contains(target - i)) {
                    using.remove(Integer.valueOf(i));
                    additional.remove(Integer.valueOf(target - i));                    
                    isDone = true;
                    paid = 1;
                    break;
                }
            }
        }
        
        // 불가능! 코인 2개 쓸거임
        if(!isDone) {
            for(int i : additional) {
                if(additional.contains(target - i)) {
                    additional.remove(Integer.valueOf(i));                    
                    additional.remove(Integer.valueOf(target - i));                    
                    isDone = true;
                    paid = 2;
                    break;
                }
            }
        }
        
        // 모두 실패하면
        if(!isDone) {
            paid = -1;
        }
         
        return paid;
    }
    
    
}