package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    private static class Solution {

        static int[] dx = {0, 0, 1, -1};
        static int[] dy = {1, -1, 0, 0};
        static int n;
        static int m;
        static boolean[][] check;
        static int answer = Integer.MAX_VALUE;

        public int solution(int[][] maps) {
            check = new boolean[maps.length][maps[0].length];
            n = maps.length;
            m = maps[0].length;

            return bfs(maps);
        }

      private static int bfs(int[][] maps) {
          Queue<Node> q = new LinkedList<>();
          q.add(new Node(0, 0, 1));
          check[0][0] = true;

          while (!q.isEmpty()) {
              Node now = q.poll();

              if (now.x == n - 1 && now.y == m - 1) {
                  return now.dist;
              }

              for (int k = 0; k < 4; k++) {
                  int nx = now.x + dx[k];
                  int ny = now.y + dy[k];

                  if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                      if (!check[nx][ny] && maps[nx][ny] == 1) {
                          if (maps[nx][ny] == 1) {
                              check[nx][ny] = true;
                              q.add(new Node(nx, ny, now.dist + 1));
                          }
                      }
                  }
              }
          }
          return -1;
      }

        private static class Node {
            int x;
            int y;
            int dist;

            public Node(int x, int y, int dist) {
                this.x = x;
                this.y = y;
                this.dist = dist;
            }
        }
    }
}
