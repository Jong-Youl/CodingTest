import java.util.*;

class Solution {
    
    public int N, M;
    public int [] dr = {-1, 1, 0, 0};
    public int [] dc = {0, 0, -1, 1};
    public boolean [][] visit;
    //각 집단에 속한 석유 칸의 정보와 해당 집단이 어느정도 분포했는지 확인할 리스트
    public List<List<Integer>> range;
    public List<Integer> point;
    
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;
    
        visit = new boolean [N][M];
        range = new ArrayList<>();
        point = new ArrayList<>();
        //각 인덱스마다 집단 리스트 생성
        for(int i = 0; i < M; i++){
            range.add(new ArrayList<>());
        }
        
        for(int r = 0 ; r < N; r++){
            for(int c = 0 ; c < M; c++){
                //해당위치에 석유가 있고 아직 군집화하지 않았다면 bfs ㄱ
                if(land[r][c] == 1 && !visit[r][c]) {
                    bfs(r, c, land);
                }                    
            } 
        }
        
        //이제 정산
        for(int i = 0; i < M; i++){
            int tmp_answer = 0;
            //해당 열에 들어오는 모든 집단 확인
            for(int j = 0; j < range.get(i).size(); j++){
                tmp_answer += point.get(range.get(i).get(j));
            }
            answer = Math.max(answer, tmp_answer);
        }
        
        return answer;
    }  
    
    public void bfs(int row, int col, int [][] land){
        int cnt = 1;
        
        //bfs를 이용
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        q.add(new int[]{row, col});
        visit[row][col] = true;
        set.add(col);
        
        while (!q.isEmpty()) {
            
            int [] tmp = q.poll();
            
            //상하좌우
            for(int i = 0; i < 4; i++) {
                int r = tmp[0] + dr[i];
                int c = tmp[1] + dc[i];
                
                // 인덱스에 벗어나면 다음 경우
                if(!check(r, c)) continue;
                
                //해당 위치가 1이고 간적이 없을 때
                //queue에 추가 + 카운트
                if(land[r][c] == 1 && !visit[r][c]) {
                    visit[r][c] = true;
                    set.add(c);
                    cnt++;
                    q.add(new int[]{r, c});
                }
                
            }
            
        }
        // 해당 집단의 카운트 저장
        point.add(cnt);
        
        Iterator<Integer> iter = set.iterator(); // set을 Iterator 안에 담기
		while(iter.hasNext()) { // iterator에 다음 값이 있다면
            int tmp_c = iter.next();
            range.get(tmp_c).add(point.size() - 1);
		}
        
        return;
    }
    
    //인덱스 확인 메소드
    public boolean check(int r, int c) {
        if(r < 0 || r >= N || c < 0 || c >= M) return false;
        else return true;
    }
    
}