//백준 1018 체스판 다시 칠하기
package baekjoon;

import java.io.*;
import java.util.*;

public class bj1018 {

	static boolean a[][];
	static int ans=64;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		a = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				if(s.charAt(j) == 'W') {
					a[i][j] = true;
				}else {
					a[i][j] = false;
				}
			}
		}
		int row = n-7;
		int col = m-7;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				go(i,j);
			}
		}	
		System.out.println(ans);
	}
	
	static void go(int x, int y) {
		int x_end = x+8;
		int y_end = y+8;
		int cnt =0;
		
		boolean color = a[x][y]; //첫번째 칸의 색
		
		for(int i=x; i<x_end; i++) {
 			for(int j=y; j<y_end; j++) {
 				if(a[i][j] != color) {
					cnt++;
				}
 				color = (!color); //다음칸은 색이 바뀜
			}
			color = !color; //다음 행의 첫번째 부분도 색이 바뀜
		}
		
		cnt = Math.min(cnt, 64-cnt); // 처음부터 다 칠할때와 그냥 칠할때
		ans = Math.min(ans, cnt);
	}
	
}
