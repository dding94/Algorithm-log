//받아쓰기
package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0303_20542 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String a = br.readLine();
        String b = br.readLine();

        int[][] d = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            d[i][0] = i;
        }

        for (int i = 0; i <= m; i++) {
            d[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (checkWord(a.charAt(i - 1) , b.charAt(j - 1))) {
                    d[i][j] = d[i - 1][j - 1];
                }else{
                    d[i][j] = Math.min(d[i - 1][j - 1], Math.min(d[i - 1][j], d[i][j - 1])) + 1;
                }
            }
        }

        System.out.println(d[n][m]);
    }

    static boolean checkWord(char a, char b) {
        if(a == b) return true;
        if(a == 'v' && (b == 'v' || b == 'w')) return true;
        if (a == 'i' && (b == 'i' || b == 'j' || b == 'l')) return true;

        return false;
    }
}
