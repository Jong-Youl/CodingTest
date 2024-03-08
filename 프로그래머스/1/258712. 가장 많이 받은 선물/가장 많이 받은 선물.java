import java.util.*;

class Solution {
    //친구들의 이름을 담은 1차원 문자열 배열 friends
    //친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 gifts A to B -> "A B" 형태
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int N = friends.length;
        int [][] giftRecord = new int [N][N];
        int [] giftScore = new int [N];
        int [] giftExpected = new int [N];
        
        //선물 주고 받은 내용 기록하기
        for(String s : gifts) {
            
            String from = s.split(" ")[0];
            String to = s.split(" ")[1];
            int fromFriend = checkGift(N, friends, from);
            int toFriend = checkGift(N, friends, to);  
        
            giftRecord[fromFriend][toFriend]++;
            
        }
        //선물 지수 확인
        for(int i = 0; i < N; i++) {
            
            int totalGiven = 0;
            int totalRecieved = 0;
            
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                totalGiven += giftRecord[i][j];
                totalRecieved += giftRecord[j][i];
            
            }
            
            giftScore[i] = totalGiven - totalRecieved;
        
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                //사람이 선물을 주고받은 기록이 있다면
                if(giftRecord[i][j] != 0 || giftRecord[j][i] != 0) {
                    //이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받음.
                    if(giftRecord[i][j] > giftRecord[j][i]){
                        //i가 준 사람 j가 받은 사람
                        //i가 j보다 많이 줬을 때
                        giftExpected[i]++;
                    }
                    else if(giftRecord[i][j] == giftRecord[j][i]) {
                        //주고받은 수가 같을 때
                        //선물 지수가 더 작은 사람에게 선물을 하나 받음.            
                        //만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않음.
                        if(giftScore[i] > giftScore[j]) {
                            giftExpected[i]++;
                        }
                        else if (giftScore[i] < giftScore[j]) {
                            giftExpected[j]++;
                        }
                    }
                    else {
                        giftExpected[j]++;
                    }

                }
                else {
                    //두 사람이 선물을 주고받은 기록이 하나도 없을 때
                    //선물 지수가 더 작은 사람에게 선물을 하나 받음.
                    if(giftScore[i] > giftScore[j]) {
                            giftExpected[i]++;
                    }
                    else if (giftScore[i] < giftScore[j]) {
                            giftExpected[j]++;
                    }                
                }
            }   
        }
        
        for (int i : giftExpected) {
            answer = Math.max(answer, i);
        }
        
        return answer;
    }
    
    public int checkGift(int N, String [] friends, String target) {
        int result = 0;
        
        for(int i = 0; i < N; i++) {
                if(target.equals(friends[i])) result = i;
        }
        
        return result;
    }
}