//백준 2178 미로찾기
package codingTest1_3;

import java.io.*;
import java.util.*;

class Pair2178{
	int x;
	int y;
	Pair2178(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class graph4_bfs {
	static final int dx[] = {0, 0,-1 ,1};
	static final int dy[] = {1,-1, 0, 0};
	static int a[][], g[][];
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n][m];
		g = new int[n][m];

		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				a[i][j] = s.charAt(j) - '0';
				g[i][j] = -1;
			}
		}
		
		bfs(0,0);
		
		System.out.println(g[n-1][m-1]);
	}
	
	static void bfs(int x, int y) {
		Queue<Pair2178> q = new LinkedList<>();
		q.add(new Pair2178(x,y));
		g[x][y] = 1;
		
		while(!q.isEmpty()) {
			Pair2178 p = q.remove();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(0<= nx && nx < n && 0<=ny && ny < m) {
					if(a[nx][ny] == 1 && g[nx][ny] == -1) {
						q.add(new Pair2178(nx,ny));		
						g[nx][ny] = g[x][y] + 1;
					}
				}			
			}
		}
		
	}
}
