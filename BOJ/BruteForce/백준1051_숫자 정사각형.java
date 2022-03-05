package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0305_1051 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        final int MIN = Math.min(n, m);
        int area = 0;
        int maxArea = 0;

        // 2차원 배열에 값 넣기
        for(int i = 0; i< n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 0; i< n; i++) {
            for(int j=0; j<m; j++) {
                for(int k=0; k<MIN; k++) {
                    if(i+k < n && j+k < m) {	// 배열 범위 이내

                        // 4개의 꼭짓점이 정사각형이 되는 조건
                        if(arr[i][j] == arr[i][j+k] && arr[i][j] == arr[i+k][j] && arr[i][j] == arr[i+k][j+k]) {
                            area = (k+1) * (k+1);
                            maxArea = Math.max(maxArea, area);
                        }
                    }
                }
            }
        }

        System.out.println(maxArea);

    }
}

