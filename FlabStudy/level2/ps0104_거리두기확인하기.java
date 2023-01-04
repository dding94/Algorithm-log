package 에프랩스터디;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ps0104_거리두기확인하기 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[][] strings = {
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"},
        };

        sol.solution(strings);

    }

    private static class Solution {

        static char[][] room;
        static int[][] dist;
        static boolean[][] visit;
        static int n, m;

        static int[] dx = {0, 0, 1, -1};
        static int[] dy = {1, -1, 0, 0};

        public int[] solution(String[][] places) {
            n = places.length;
            m = places[0].length;

            int[] answer = new int[n];
            int index = 0;
            dist = new int[n][m];
            visit = new boolean[n][m];
            //강의실 별 순회
            for (String[] place : places) {

                room = new char[n][m];

                //강의실을 2차원 배열로 만듬
                for (int i = 0; i < n; i++) {
                    String s = place[i];
                    for (int j = 0; j < s.length(); j++) {
                        room[i][j] = s.charAt(j);
                        dist[i][j] = -1;
                    }
                }

                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (room[i][j] == 'P' && !flag) {
                            if (!bfs(i, j)) {
                                flag = true;
                            }
                        }
                    }
                }

                if (flag) {
                    answer[index] = 0;
                } else {
                    answer[index] = 1;
                }

                index++;
            }

            return answer;
        }

        private static boolean bfs(int x, int y) {
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(x, y));
            int[][] copyDist = new int[n][m];
            char[][] copyRoom = new char[n][m];
            boolean[][] copyVisit = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copyDist[i][j] = dist[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copyRoom[i][j] = room[i][j];
                }
            }


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copyVisit[i][j] = visit[i][j];
                }
            }


            copyDist[x][y] = 0;
            copyRoom[x][y] = 'C';
            copyVisit[x][y] = true;

            while (!q.isEmpty()) {
                Node now = q.poll();
                //현재 위치
                x = now.x;
                y = now.y;

                //갈수있는 방향
                for (int k = 0; k < 4; k++) {
                    int nx = dx[k] + x;
                    int ny = dy[k] + y;

                    //벽 밖으로 나가면 안됨
                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        //방문하지 않았고 다음으로 가야할 방향이 파티션이 아닌경우
                        if (!copyVisit[nx][ny] && copyRoom[nx][ny] != 'X' && copyDist[nx][ny] == -1) {
                            q.add(new Node(nx, ny));
                            copyVisit[nx][ny] = true;
                            copyDist[nx][ny] = copyDist[x][y] + 1;
                        }
                    }
                }

            }

             for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copyRoom[i][j] == 'P' && copyDist[i][j] <= 2 && copyVisit[i][j]) {
                           return false;
                    }
                }
            }

            return true;
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

    //여기까지
}
