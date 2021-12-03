//백준 1010 다리 놓기 조합의 성질 이용하여 풀기
package baekjoon;

import java.io.*;
import java.util.*;

public class bj1010 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int max = 29;
		int d[][] = new int[max+1][max+1];
		
		for(int i=0; i<=max; i++) {
			d[i][i] = 1;
			d[i][0] = 1;
		}
		
		for(int i=1; i<=max; i++) {
			for(int j=1; j<=max; j++) {
				d[i][j] = d[i-1][j-1] + d[i-1][j];
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			//mCn
			sb.append(d[m][n]).append('\n');
		}
		System.out.println(sb);
	}
}
