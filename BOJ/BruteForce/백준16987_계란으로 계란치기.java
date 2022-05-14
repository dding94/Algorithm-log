package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0514_16987 {

    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Egg> eggs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            eggs.add(new Egg(durability, weight));
        }

        dfs(0, eggs);

        System.out.println(ans);
    }

    private static void dfs(int depth, ArrayList<Egg> eggs) {
        if (depth == eggs.size()) {
            int cnt = 0;
            for (Egg egg : eggs) {
                if (egg.durability <= 0) {
                    cnt++;
                }
            }

            ans = Math.max(ans, cnt);
            return;
        }

        int broken = 0;
        for (int i = 0; i < eggs.size(); i++) {
            if(i == depth) continue;
            if (eggs.get(i).durability <= 0) {
                broken++;
            }
        }
        if (broken == eggs.size() - 1) {
            dfs(depth+1, eggs);
        }

        if (eggs.get(depth).durability <= 0) {
            dfs(depth + 1, eggs);
            return;
        }

        for (int i = 0; i < eggs.size(); i++) {
            if (i == depth || eggs.get(i).durability <= 0) {
                continue;
            }

            eggs.get(depth).durability -= eggs.get(i).weight;
            eggs.get(i).durability -= eggs.get(depth).weight;
            dfs(depth + 1, eggs);
            eggs.get(depth).durability += eggs.get(i).weight;
            eggs.get(i).durability += eggs.get(depth).weight;
        }
    }

    static class Egg{
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
