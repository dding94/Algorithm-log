//백준 2580 스도쿠
package codingTest2_1;

import java.io.*;
import java.util.*;

public class BackTracking2_1 {

	static final int n = 9;
	static int a[][];
	static boolean c[][][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = new int[n][n];
		c = new boolean[3][n][10]; // 가로, 세로, 정사각형  , 1~10까지의 수 저장
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(a[i][j] != 0) {
					c[0][i][a[i][j]] = true;
					c[1][j][a[i][j]] = true;
					c[2][square(i,j)][a[i][j]] = true;
				}			
			}
		}
		
		go(0);
		
		System.out.println(sb);
	}
	static boolean go(int depth) {
		if(depth == 81) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sb.append(a[i][j] + " ");
				}
				sb.append('\n');
			}
			return true;
		}
		int x = depth / n;
		int y = depth % n;
		if(a[x][y] != 0) { //빈칸이 아닐경우
			return go(depth+1);
		}else { //빈칸일 경우
			for(int i=1; i<=9; i++) {
				if(!c[0][x][i] && !c[1][y][i] && !c[2][square(x,y)][i]) {
					c[0][x][i] = c[1][y][i] = c[2][square(x,y)][i] = true;
					a[x][y] = i;
					if(go(depth+1)) {
						return true;
					}
					a[x][y] = 0;
					c[0][x][i] = c[1][y][i] = c[2][square(x,y)][i] = false;
				}
			}
		}
		
		
		return false;
	}
	
	static int square(int x, int y) {
		return 3*(x/3) + (y/3);
	}

}
