//백준 2667 단지번호 붙이기

package codingTest1_3;

import java.io.*;
import java.util.*;

class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}


public class graph3_bfs {

	static final int dx[] = {0,0,-1,1};
	static final int dy[] = {1,-1,0,0};
	static int a[][];
	static int g[][];
	static int n;
	static int dange;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		a = new int[n][n];
		g = new int[n][n];
		
		for(int i=0;i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}	
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] == 1 && g[i][j] == 0) {
					dange ++;
					bfs(i,j);
				}
			}
		}
		int ans[] = new int[dange];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(g[i][j] != 0) {
					ans[g[i][j] -1] += 1;					
				}
			}
		}
		
		Arrays.sort(ans);
		sb.append(dange).append('\n');
		for(int i=0; i<dange; i++) {
			sb.append(ans[i]).append('\n');
		}
		System.out.println(sb);
		
	}
	
	static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		
		q.add(new Pair(x,y));
		g[x][y] = dange;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(0 <= nx && nx < n && 0<=ny && ny < n) {
					if(a[nx][ny] == 1 && g[nx][ny] == 0) {
						g[nx][ny] = dange;
						q.add(new Pair(nx,ny));
					}
				}
				
			}	
		}
	}
}
