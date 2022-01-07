//백준 10026 - 적록색약

import java.util.*;
import java.io.*;
public class Main{
 
    static int n;
    static char map[][];
    static boolean visits[][];
    static final int dx[] = {0,0,1,-1};
    static final int dy[] = {1,-1,0,0};
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visits = new boolean[n][n];
 
        for (int i=0; i<n; i++){
            String s = br.readLine();
            for (int j=0; j<n; j++){
                map[i][j] = s.charAt(j); 
            }
        }
 
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visits[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        sb.append(cnt + " ");
        cnt=0;
        visits = new boolean[n][n];
 
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]=='G'){
                    map[i][j] = 'R'; // G를 R로 바꿔준다.
                }
            }
        }
     
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visits[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
 
    }
 
    static void dfs(int x, int y){
        visits[x][y] = true;
        char tmp_char = map[x][y]; 
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(0>nx || nx >= n || 0 > ny || ny >= n) continue;
 
            if (!visits[nx][ny] && map[nx][ny] == tmp_char){
                dfs(nx, ny);
            }
        }
    }
    
}