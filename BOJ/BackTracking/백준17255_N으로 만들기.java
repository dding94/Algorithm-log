package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0717_17255 {

    static int n;
    static String s;
    static Set<String> hs = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        n = s.length();

        dfs(0, s, s);

        System.out.println(hs.size());
    }

    private static void dfs(int depth, String now, String path) {
        if (depth == n - 1) {
            hs.add(path);
            return;
        }


        dfs(depth + 1, now.substring(1), path + now.substring(1));
        dfs(depth + 1, now.substring(0, now.length() - 1), path + now.substring(0, now.length() - 1));
    }
}
