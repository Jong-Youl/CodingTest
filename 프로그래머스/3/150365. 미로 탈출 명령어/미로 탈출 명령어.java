import java.util.*;
import java.io.*;

class Solution {
    
    //사전순으로 넣기 때문에 사전순인 하, 좌, 우, 상 순으로 넣을거임
    public int [] dr = {1, 0, 0, -1};
    public int [] dc = {0, -1, 1, 0};
    
    public String [] commend = { "d", "l", "r", "u"};
    public boolean visit = false;
    public String answer;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "impossible";
        
        //시작점에서 부터 움직여야 함
        //0부터 시작할거라서 그냥 -1하고 시작함
        dfs(n-1, m-1, x-1, y-1, r-1, c-1, k, "");
        
        return answer;
    }
    
    public void dfs (int n, int m, int x, int y, int r, int c, int k, String str) {
        int dist = getDistance(x, y, r, c);
        
        if(k < dist || (k - dist) % 2 == 1) return;
        
        //완료
        if(k == 0) {
            if(x == r && y == c) {
                visit = true;
                answer = str;
            }
            return;
        }
        
        for(int i = 0; i < 4; i++) {            
            int nx = x + dr[i];
            int ny = y + dc[i];
            String tmp = str + commend[i];
            //인덱스 확인
            if(nx >= 0 && ny >= 0 && nx <= n && ny <= m) {
                dfs(n, m, nx, ny, r, c, k-1, tmp);            
            }
            
            if(visit) return;
        }
    }
    
    public int getDistance (int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }
    
}