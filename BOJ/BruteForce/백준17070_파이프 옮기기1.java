package 백준;

//파이프 옮기기 1
import java.io.*;
import java.util.*;

public class PS0129_17070 {

    static int n, cnt;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        cnt = 0;
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0);

        System.out.println(cnt);
    }


    // 0가로 , 1세로, 2 대각선
    static void dfs(int x, int y, int state) {
        if (x == n - 1 && y == n - 1) {
            cnt++;
            return;
        }


        if(state == 0){
            if(y+1 < n && map[x][y+1] == 0){
                dfs(x, y + 1, 0);
            }
        }else if(state == 1){
            if(x+1 < n && map[x+1][y] == 0){
                dfs(x+1, y, 1);
            }
        }else if(state == 2){
            if(y+1 < n && map[x][y+1] == 0){
                dfs(x, y + 1, 0);
            }
            if(x+1 < n && map[x+1][y] == 0){
                dfs(x+1, y , 1);
            }
        }

        //대각선은 모든 방향에서 갈 수 있어 중복이 되어 따로 처리
        if (x + 1 < n && y + 1 < n && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }


    }

}
