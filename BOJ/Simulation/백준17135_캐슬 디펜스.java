package 백준.PS3월;

import java.io.*;
import java.util.StringTokenizer;

public class PS0322_17135 {

    static int n, m, d, ans;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        dfs(0);

        System.out.println(ans);

    }

    static void dfs(int archer) {
        if(archer == 3){
            ans = Math.max(ans, kill());
            return;
        }


        for (int i = 0; i < m; i++) {
            if(map[n][i] == 0){
                map[n][i] = 2;
                dfs(archer + 1);
                map[n][i] = 0;
            }
        }
    }

    static int kill() {
        int[][] copyMap = new int[n + 1][m];
        boolean[][] target = new boolean[n][m];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        int turn = n;
        int sum = 0;
        while (turn-- > 0) {
            for (int k = 0; k < m; k++) {
                if(copyMap[n][k] == 2){ //궁수 위치
                    int r1 = n;
                    int c1 = k;
                    int minDistance = 100;
                    int minX = 100;
                    int minY = 100;

                    //가장 가까운 적 구하기
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (copyMap[i][j] == 1) { //적 위치
                                int r2 = i;
                                int c2 = j;

                                int dist = distance(r1, c1, r2, c2); //적과의 거리

                                if(dist <= d){ //공격범위 내에 있어야함.
                                    if (minDistance == dist) { //같은 거리일 경우
                                        if (minY > c2) {
                                            minX = r2;
                                            minY = c2;
                                        }
                                    } else if (minDistance > dist) {
                                        minDistance = dist;
                                        minX = r2;
                                        minY = c2;
                                    }
                                }

                            }
                        }
                    }
                    if (minX != 100 && minY != 100) {
                        target[minX][minY] = true; //타겟체크
                    }
                }
            }
            sum += countEnemy(target, copyMap);
            target = new boolean[n][m];
            moveEnemy(copyMap);
        }


        return sum;
    }

    static void moveEnemy(int[][] copyMap){
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = copyMap[i - 1][j];
            }
        }

        for (int i = 0; i < m; i++) {
            copyMap[0][i] = 0;
        }

    }

    static int countEnemy(boolean[][] target, int[][] copyMap) {
        int count =0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(target[i][j]){
                    count++;
                    copyMap[i][j] = 0;
                }
            }
        }
        return count;
    }

    static int distance(int r1, int c1, int r2, int c2){
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

}
