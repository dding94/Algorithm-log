//백준 7569 토마토
package codingTest1_3;

import java.io.*;
import java.util.*;

class Pair7569{
	int x;
	int y;
	int z;
	Pair7569(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class graph5 {
	
	static final int dx[] = {0,0,-1,1,0,0};
	static final int dy[] = {1,-1,0,0,0,0};
	static final int dz[] = {0,0,0,0,1,-1};
	static int a[][][];
	static int g[][][];
	
	static int n, m, h; 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		a = new int[n][m][h];
		g = new int[n][m][h];
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					a[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		bfs();
		
		int ans = 0;
		
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(ans < g[i][j][k]) ans = g[i][j][k];
				}
			}
		}
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(a[i][j][k] == 0 && g[i][j][k] == 0) {
						ans = -1;
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Pair7569> q = new LinkedList<>();
		
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(a[i][j][k] == 1) {
						q.add(new Pair7569(i,j,k));
					}
				}
			}
		}
	
		while(!q.isEmpty()) {
			Pair7569 p = q.remove();
			int x = p.x;
			int y = p.y;
			int z = p.z;
			
			for(int k=0; k<6; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				int nz = z + dz[k];
				
				if(0<=nx && nx<n && 0<=ny && ny<m && 0<=nz && nz<h) {
					if(a[nx][ny][nz] == 0 && g[nx][ny][nz] == 0) {
						a[nx][ny][nz] = 1;
						q.add(new Pair7569(nx,ny,nz));
						g[nx][ny][nz] = g[x][y][z] + 1;
					}
				}
				
			}			
		}		
	}

}
