//백준 16395 파스칼의 삼각형

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<i+1; j++){
                if(j == 0 || j == i){
                    dp[i][j] = 1;
                } else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n-1][k-1]);
    }
}