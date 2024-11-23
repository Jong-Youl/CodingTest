class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int idx = 0;
        
        for (int[] target : balls) {
            int min = Integer.MAX_VALUE;

            // 4가지 방향에 대해 각각 검토
            // 위쪽 벽 반사
            if (!(startY < target[1] && startX == target[0])) {
                if (!isBlocked(startX, startY, target[0], target[1], m, n, 0)) {
                    min = Math.min(min, getDistance(m, n, startX, startY, target[0], target[1], 0));
                }
            }

            // 아래쪽 벽 반사
            if (!(startY > target[1] && startX == target[0])) {
                if (!isBlocked(startX, startY, target[0], target[1], m, n, 1)) {
                    min = Math.min(min, getDistance(m, n, startX, startY, target[0], target[1], 1));
                }
            }

            // 왼쪽 벽 반사
            if (!(startX > target[0] && startY == target[1])) {
                if (!isBlocked(startX, startY, target[0], target[1], m, n, 2)) {
                    min = Math.min(min, getDistance(m, n, startX, startY, target[0], target[1], 2));
                }
            }

            // 오른쪽 벽 반사
            if (!(startX < target[0] && startY == target[1])) {
                if (!isBlocked(startX, startY, target[0], target[1], m, n, 3)) {
                    min = Math.min(min, getDistance(m, n, startX, startY, target[0], target[1], 3));
                }
            }
            
            answer[idx++] = min;
        }         
        
        return answer;
    }
    
    // 검은 공이 경로를 방해하는지 확인하는 함수
    public boolean isBlocked(int sX, int sY, int tX, int tY, int maxX, int maxY, int dir) {
        int bx = 0, by = 0; // 검은 공의 좌표는 balls 배열에서 가져온다고 가정
        
        if (dir == 0) {
            // 위쪽 벽 반사
            int reflectedTX = tX;
            int reflectedTY = 2 * maxY - tY;
            return (bx == reflectedTX && by > sY && by < reflectedTY); // 검은 공이 경로에 있다면
        } else if (dir == 1) {
            // 아래쪽 벽 반사
            int reflectedTX = tX;
            int reflectedTY = -tY;
            return (bx == reflectedTX && by < sY && by > reflectedTY); // 검은 공이 경로에 있다면
        } else if (dir == 2) {
            // 왼쪽 벽 반사
            int reflectedTX = -tX;
            int reflectedTY = tY;
            return (by == reflectedTY && bx > sX && bx < reflectedTX); // 검은 공이 경로에 있다면
        } else {
            // 오른쪽 벽 반사
            int reflectedTX = 2 * maxX - tX;
            int reflectedTY = tY;
            return (by == reflectedTY && bx < sX && bx > reflectedTX); // 검은 공이 경로에 있다면
        }
    }
    
    public int getDistance(int maxX, int maxY, int sX, int sY, int tX, int tY, int dir) {
        int distance = 0;
        
        if (dir == 0) {
            // 위쪽 벽 반사
            int reflectedTX = tX;
            int reflectedTY = 2 * maxY - tY;
            distance = (int) (Math.pow(sX - reflectedTX, 2) + Math.pow(sY - reflectedTY, 2));
        } else if (dir == 1) {
            // 아래쪽 벽 반사
            int reflectedTX = tX;
            int reflectedTY = -tY;
            distance = (int) (Math.pow(sX - reflectedTX, 2) + Math.pow(sY - reflectedTY, 2));
        } else if (dir == 2) {
            // 왼쪽 벽 반사
            int reflectedTX = -tX;
            int reflectedTY = tY;
            distance = (int) (Math.pow(sX - reflectedTX, 2) + Math.pow(sY - reflectedTY, 2));
        } else {
            // 오른쪽 벽 반사
            int reflectedTX = 2 * maxX - tX;
            int reflectedTY = tY;
            distance = (int) (Math.pow(sX - reflectedTX, 2) + Math.pow(sY - reflectedTY, 2));
        }
        
        return distance;
    }
}
