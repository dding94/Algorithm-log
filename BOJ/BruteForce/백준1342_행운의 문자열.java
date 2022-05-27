package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0527_1342 {
    static int count = 0;
    static boolean[] check;
    static HashSet<String> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        check = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();

        dfs(0, sb, s);

        System.out.println(count);
    }

    private static void dfs(int depth, StringBuilder luckyString, String input) {
        if (depth == input.length()) {
            if(hs.add(String.valueOf(luckyString))){
                if(isLuckyString(String.valueOf(luckyString))){
                    count++;
                }
            }
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                luckyString.append(input.charAt(i));
                dfs(depth + 1, luckyString, input);
                check[i] = false;
                luckyString.deleteCharAt(luckyString.length() - 1);
            }
        }
    }

    private static boolean isLuckyString(String luckyString) {
        for (int i = 1; i < luckyString.length(); i++) {
            if (luckyString.charAt(i) == luckyString.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
