//프로그래머스 네트워크
class Solution {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(visit[i] == false){
              dfs(i, computers,visit);
              answer++;
            } 
        }
        
        return answer;
    }
    
    public void dfs(int i, int[][] com, boolean visit[]){
        visit[i] = true;
        
        for(int j=0; j<com.length; j++){
            if(i==j) continue;
            if(visit[j] == false && com[i][j] == 1){
                dfs(j,com,visit);
            } 
        }
    }
}