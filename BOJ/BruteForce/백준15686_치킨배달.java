//백준 15686 치킨배달
package 백준;

import java.io.*;
import java.util.*;

public class PS0209_15686 {

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m , ans;
    static int[][] map;
    static ArrayList<Node> house = new ArrayList<>();
    static ArrayList<Node> chicken = new ArrayList<>();
    static boolean[] openStore;

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
        openStore = new boolean[chicken.size()];
        ans = Integer.MAX_VALUE;

        dfs(0, 0);

        System.out.println(ans);
    }

    private static void dfs(int index, int start) {
        if (index == m) {
            int chickenRoad = 0;
            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (openStore[j]) {
                        int diff = Math.abs(house.get(i).x - chicken.get(j).x)
                                + Math.abs(house.get(i).y - chicken.get(j).y);
                        if (temp > diff) {
                            temp = diff;
                        }
                    }
                }
                chickenRoad += temp;
            }
            if (ans > chickenRoad) {
                ans = chickenRoad;
            }
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            openStore[i] = true;
            dfs(index + 1, i+1 );
            openStore[i] = false;
        }

    }
}
