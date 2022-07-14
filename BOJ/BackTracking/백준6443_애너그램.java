package 백준.PS7월;

import java.io.*;

public class PS0714_6443 {

    static StringBuilder sb = new StringBuilder();
    static char[] ansList;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            visit = new int[26];

            for (char c : input) {
                visit[c - 'a']++;
            }
            ansList = new char[input.length];
            dfs(0);
        }

        System.out.println(sb);
    }


    private static void dfs(int depth) {
        if (depth == ansList.length) {
            sb.append(ansList).append("\n");
            return;
        }


        for (int i = 0; i < 26; i++) {
            if (visit[i] >= 1) {
                visit[i]--;
                ansList[depth] = (char) (i + 'a');
                dfs(depth + 1);
                visit[i]++;
            }
        }
    }
}
