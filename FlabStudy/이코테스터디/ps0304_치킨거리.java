package 에프랩스터디.이코테;

import java.io.*;
import java.util.*;

public class ps0304_치킨거리 {

    static int n, m, answer;
    static int[][] map;
    static boolean[] open;
    static List<Node> house = new ArrayList<>();
    static List<Node> chicken = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    house.add(new Node(i, j));
                }

                if (map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        open = new boolean[chicken.size()];
        answer = Integer.MAX_VALUE;

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            calChickenRoad();
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            dfs(depth + 1, i + 1);
            open[i] = false;
        }
    }

    private static void calChickenRoad() {
        int chickenRoad = 0;

        for (int i = 0; i < house.size(); i++) {
            int temp = Integer.MAX_VALUE;

            for (int j = 0; j < chicken.size(); j++) {
                if (open[j]) {
                    int diff = Math.abs(house.get(i).x - chicken.get(j).x)
                        + Math.abs(house.get(i).y - chicken.get(j).y);

                    temp = Math.min(temp, diff);
                }
            }
            chickenRoad += temp;
        }

        answer = Math.min(answer, chickenRoad);
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
