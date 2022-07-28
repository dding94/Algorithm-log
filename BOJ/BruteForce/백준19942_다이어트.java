package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0728_19942 {

    static int n, baseMp, baseMf, baseMs, baseMv;
    static int minCost = Integer.MAX_VALUE;
    static ArrayList<Item> items = new ArrayList<>();
    static ArrayList<Item> temp = new ArrayList<>();
    static ArrayList<String> answer = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        baseMp = Integer.parseInt(st.nextToken());
        baseMf = Integer.parseInt(st.nextToken());
        baseMs = Integer.parseInt(st.nextToken());
        baseMv = Integer.parseInt(st.nextToken());
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int mp = Integer.parseInt(st.nextToken());
            int mf = Integer.parseInt(st.nextToken());
            int ms = Integer.parseInt(st.nextToken());
            int mv = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            items.add(new Item(mp, mf, ms, mv, cost, i + 1));
        }

        for (int i = 1; i <= n; i++) {
            temp = new ArrayList<>();
            dfs(0, i, 0);
        }

    }

    static void dfs(int depth, int select, int start) {
        if (depth == select) {
            if (answerCheck()) {
                String s = "";
                for (Item item : items) {
                    s += item.seq;
                }
                System.out.println(s);
            }
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                temp.add(items.get(i));
                dfs(depth + 1, select, i + 1);
                temp.remove(temp.size() - 1);
                visit[i] = false;
            }
        }
    }
    private static boolean answerCheck() {
        int mp = 0;
        int mf = 0;
        int ms = 0;
        int mv = 0;
        int cost = 0;

        for (Item item : temp) {
            mp += item.mp;
            mf += item.mf;
            ms += item.ms;
            mv += item.mv;
            cost += item.cost;
        }

        if (mp >= baseMp && mf >= baseMf && ms > -baseMs && mv >= baseMv) {
            if (minCost >= cost) {
                minCost = cost;
                return true;
            }
        }
        return false;
    }

    static class Item {
        int mp;
        int mf;
        int ms;
        int mv;
        int cost;
        int seq;

        public Item(int mp, int mf, int ms, int mv, int cost, int seq) {
            this.mp = mp;
            this.mf = mf;
            this.ms = ms;
            this.mv = mv;
            this.cost = cost;
            this.seq = seq;
        }
    }
}
