package 에프랩스터디.이코테;

import java.io.*;
import java.util.*;

public class ps0202_인구이동 {

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    static int n, l, r, answer;
    static int[][] map;
    static boolean[][] visit;
    static boolean isMove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        System.out.println(answer);
    }

    private static void solve() {

        //최대 2000번
        while (true) {
            // 움직임 여부를 움직이지 않음으로 매번 초기화
            isMove = false;
            // 매일 방문을 초기화 해야한다.
            visit = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            // 움직였으면 요일을 올리고 그렇지 않으면 탈출한다.
            if (isMove) {
                answer++;
            } else {
                break;
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        // 인구이동 좌표를 계산하기 위한 자료구조
        List<Node> union = new ArrayList<>();

        visit[x][y] = true;
        q.add(new Node(x, y));
        union.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node now = q.poll();
            x = now.x;
            y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && !visit[nx][ny]) {
                    int diff = Math.abs(map[x][y] - map[nx][ny]);

                    if (l <= diff && diff <= r) {
                        q.add(new Node(nx, ny));
                        visit[nx][ny] = true;
                        union.add(new Node(nx, ny));
                    }
                }
            }
        }

        if (union.size() > 1) {
            isMove = true;
            int totalPeople = 0;

            for (Node node : union) {
                totalPeople += map[node.x][node.y];
            }

            for (Node node : union) {
                map[node.x][node.y] = totalPeople / union.size();
            }
        }

    }

    private static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
