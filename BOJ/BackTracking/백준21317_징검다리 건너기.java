package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0712_21317 {

    static int n, k, ans;
    static ArrayList<Jump> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken());
            int big = Integer.parseInt(st.nextToken());

            list.add(new Jump(small, big));
        }
        k = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        dfs(1, 0, false);
        //bfs();

        System.out.println(ans);
    }

    private static void dfs(int depth, int energy, boolean superJump) {
        if (depth == n) {
            ans = Math.min(ans, energy);
            return;
        }

        if (energy > ans) {
            return;
        }

        if (depth + 1 <= n) {
            dfs(depth + 1, energy + list.get(depth-1).smallJump, superJump);
        }
        if (depth + 2 <= n) {
            dfs(depth + 2, energy + list.get(depth-1).bigJump, superJump);
        }
        if (!superJump && depth + 3 <= n) {
            dfs(depth + 3, energy + k, true);
        }
    }

    private static void bfs() {
        Queue<Stone> q = new LinkedList<>();
        q.add(new Stone(1, 0, false));

        while (!q.isEmpty()) {
            Stone now = q.poll();

            if (now.x > n) {
                continue;
            }

            if (now.x == n) {
                ans = Math.min(ans, now.energy);
                continue;
            }

            //작은점프
            q.add(new Stone(now.x + 1, now.energy + list.get(now.x - 1).smallJump, now.bigJump));
            q.add(new Stone(now.x + 2, now.energy + list.get(now.x - 1).bigJump, now.bigJump));
            if (!now.bigJump) {
                q.add(new Stone(now.x + 3, now.energy + k, true));
            }
        }
    }

    private static class Jump {
        int smallJump;
        int bigJump;

        public Jump(int smallJump, int bigJump) {
            this.smallJump = smallJump;
            this.bigJump = bigJump;
        }
    }

    private static class Stone {
        int x;
        int energy;
        boolean bigJump;

        public Stone(int x, int energy, boolean bigJump) {
            this.x = x;
            this.energy = energy;
            this.bigJump = bigJump;
        }
    }

}
