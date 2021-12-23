//백준 16931 겉넓이 구하기
package Practice;

import java.io.*;
import java.util.*;

public class bj16931 {
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int a[][] = new int[102][102];
				
		
		for(int i=1; i<=n; i++) { 
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 2*n*m; 
		
		for(int x=1; x<=n; x++) {
			for(int y=1; y<=m; y++) {
				for(int k=0; k<4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if(a[x][y] - a[nx][ny] >=0) { //다음 방향의 높이 비교 
						ans += a[x][y]-a[nx][ny]; //작을 경우의 높이의 차이만큼 추가
					}
				}
			}
		}
		System.out.println(ans);
	}
}
