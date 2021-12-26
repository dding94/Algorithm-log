//백준 2583 영역 구하기
package Practice;

import java.io.*;
import java.util.*;

public class bj2583 {
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static int n,m,count;
	static int a[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		a = new int[n][m];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int x=y1; x<y2; x++) {
				for(int y=x1; y<x2; y++){
					a[x][y] = 1;
				}
			}
		}
		
		ArrayList<Integer> areaCount = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j] == 0) {
					count = 0;
					dfs(i,j);
					areaCount.add(count);
				}
			}
		}
		
		Collections.sort(areaCount);
		StringBuilder sb = new StringBuilder();
		
		sb.append(areaCount.size()).append('\n');
		for(int i : areaCount) {
			sb.append(i + " ");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		a[x][y] = 1;
		count ++;
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(0<=nx && nx<n && 0<=ny && ny < m) {
				if(a[nx][ny] == 0) {
					dfs(nx,ny);
				}
			}
		}
	}

}
