//직사각형으로 나누기 G5
package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0725_1527 {

    static int a, b, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dfs(0);

        System.out.println(ans);
    }

    private static void dfs(long num) {
        if (num > b) {
            return;
        }

        if (a <= num && num <= b) {
            ans++;
        }

        dfs(num * 10 + 4);
        dfs(num * 10 + 7);
    }
}
