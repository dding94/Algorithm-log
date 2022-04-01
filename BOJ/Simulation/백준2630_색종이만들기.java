package 백준.PS4월;

import java.io.*;
import java.util.StringTokenizer;

public class PS0401_2630 {

    static int[][] paper;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paperCut(n, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    static void paperCut(int n, int x, int y) {
        if(check(n, x, y)){
            if(paper[x][y] == 1){
                blue++;
            }else{
                white++;
            }
            return;
        }

        paperCut(n / 2, x, y);
        paperCut(n / 2, x, y + n / 2);
        paperCut(n / 2, x + n / 2, y);
        paperCut(n / 2, x + n / 2, y + n / 2);

    }

    static boolean check(int n, int x, int y) {
        int color = paper[x][y];

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (color != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
