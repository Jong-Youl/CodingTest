class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int [balls.length];
        int idx = 0;
        
        for (int [] target : balls) {
            // 피타고라스 문제임, 벽에 부딪힐 때 사방을 다 비교
            // 상, 하, 좌, 우
            int min = Integer.MAX_VALUE;
            for(int dir = 0; dir < 4; dir++) {
                if(dir == 0) {
                    if(startY < target[1] && startX == target[0]) 
                        continue;
                }
                else if(dir == 1) {
                    if(startY > target[1] && startX == target[0]) 
                        continue;
                }
                else if(dir == 2) {
                    if(startY == target[1] && startX > target[0]) 
                        continue;
                }
                else {
                    if(startY == target[1] && startX < target[0]) 
                        continue;
                }
                
                min = Math.min(min, getDistance(dir, m, n, startX, startY, target[0], target[1]));
            }
            
            answer[idx++] = min;
        }         
        
        return answer;
    }
    
    
    public int getDistance(int dir, int maxX, int maxY, int sX, int sY, int tX, int tY) {
        int distance = 0;
        
        if(dir == 0) {
            // 위
            distance += Math.pow((maxY * 2 - (sY + tY)), 2) + Math.pow(sX - tX, 2);
        }
        else if (dir == 1) {
            // 아래
            distance += Math.pow((sY + tY), 2) + Math.pow(sX - tX, 2);
        }
        else if (dir == 2) {
            // 왼쪽
            distance += Math.pow(sY - tY, 2) + Math.pow((sX + tX), 2);
        }
        else {
            // 오른쪽 찍고 오는 경우
            distance += Math.pow(sY - tY, 2) + Math.pow(maxX * 2 - (sX + tX), 2);
        }
   
        return distance;
    }
}