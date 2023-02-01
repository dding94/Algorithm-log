package 에프랩스터디.이코테;

import java.io.*;
import java.util.*;

public class ps0201_경쟁적전염 {

    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int[][] map;
    static int n, s, searchX, searchY;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        List<Node> virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    virus.add(new Node(i, j, 0, map[i][j]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        searchX = Integer.parseInt(st.nextToken());
        searchY = Integer.parseInt(st.nextToken());

        virus.sort((o1, o2) -> o1.kind - o2.kind);
        q.addAll(virus);

        bfs();

        System.out.println(map[searchX - 1][searchY - 1]);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();

            int x = now.x;
            int y = now.y;

            if (now.time == s) {
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = now.kind;
                        q.add(new Node(nx, ny, now.time + 1, now.kind));
                    }
                }
            }
        }
    }

    private static class Node {

        int x;
        int y;
        int time;
        int kind;

        public Node(int x, int y, int time, int kind) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.kind = kind;
        }
    }

}
