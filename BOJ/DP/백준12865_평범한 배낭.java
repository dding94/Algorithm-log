package 백준.PS3월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PS0323_12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게
        int[][] d = new int[n + 1][k + 1];
        int[][] item = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            item[i][0] = Integer.parseInt(st.nextToken()); //무게
            item[i][1] = Integer.parseInt(st.nextToken()); //가치
        }

        for (int i = 1; i <= n; i++) { //물건의 개수
            //무게가 1부터 K까지 인 경우
            for (int j = 1; j <= k; j++){
                //해당 위치에 물건을 넣을 수 없는 경우
                if (item[i][0] > j) {
                    d[i][j] = d[i - 1][j];
                }else{
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - item[i][0]] + item[i][1]);
                }
            }
        }

        System.out.println(d[n][k]);

    }
}
