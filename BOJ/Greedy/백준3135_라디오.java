package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0519_3135 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        int min = Math.abs(a - b);

        // 즐겨찾기 입력받기
        for (int i = 0; i < n; i++) {
            // 즐겨찾기 값을 받아서 저장
            int favorite = Integer.parseInt(br.readLine());

            // (즐겨찾기와 듣고싶은 주파수의 차이) + 즐겨찾기로 이동하는 수 +1 vs 지금까지 최소 차이
            min = Math.min(Math.abs(b - favorite) + 1, min);
        }

        // 최소 차이 출력
        System.out.println(min);
    }
}
