//프로그래머스 정수 삼각형

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int n = triangle.length;
        int d[][] = new int[n+1][n+1];
        int a[][] = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                a[i][j] = triangle[i-1][j-1];
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                d[i][j] = Math.max(d[i-1][j-1] , d[i-1][j]) + a[i][j];
            }
        }


        for(int i=1; i<=n ;i++){
            if(answer < d[n][i]) answer = d[n][i];
        }

        return answer;
    }
}