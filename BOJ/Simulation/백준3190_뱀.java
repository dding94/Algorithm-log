package 이코테.Simulation;

import java.io.*;
import java.util.*;

public class simulQ5 {

    static int n;
    static int d =0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static Map<Integer, String> moveInfo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        map = new int[n][n];


        while(k-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            map[x][y] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        while(l-->0){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            moveInfo.put(time, dir);
        }

        bfs();

    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int time =0;
        int px =0;
        int py =0;

        while(true) {
            int nx = px + dx[d];
            int ny = py + dy[d];
            time++;

            // 벽 부딪힘
            if(nx<0 || ny<0 || nx>n-1|| ny> n-1) {
                break;
            }

            // 몸통 부딪힘
            if(q.contains(ny*n +nx)){
                break;
            }

            // 안 부딪히면 뱀 이동시작
            if(map[ny][nx] ==1) {
                map[ny][nx] = 0;
                q.add(ny*n +nx);
            }else {
                q.add(ny*n +nx);
                q.poll();
            }

            // 방향 전환
            if(moveInfo.containsKey(time)) {
                String data = moveInfo.get(time);
                if(data.equals("D")) {
                    d +=1;
                    if(d==4)  d=0;
                }else {
                    d -=1;
                    if(d==-1) d=3;
                }
            }
            px = nx;
            py = ny;
        }
        System.out.println(time);
    }

}

