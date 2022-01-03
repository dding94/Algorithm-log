//백준 16948 데스나이트
package Practice;

import java.io.*;
import java.util.*;

class P16948{
	int x;
	int y;
	P16948(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class bj16948 {

	static final int dx[] = {-2, -2, 0, 0, 2, 2};
	static final int dy[] = {-1, 1, -2, 2, -1, 1};
	static int dist[][];
	//static boolean isMove = false;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dist = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dist[i][j] = -1;
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		bfs(r1,c1);
		
		System.out.println(dist[r2][c2]);
	}
	
	static void bfs(int x, int y) {
		Queue<P16948> q = new LinkedList<>();
		q.add(new P16948(x,y));
		dist[x][y] = 0;
		
		while(!q.isEmpty()) {
			P16948 p = q.poll();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<6; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(0<= nx && nx < n && 0 <= ny && ny <n) {
					if(dist[nx][ny] == -1) {
						//isMove = true;
						dist[nx][ny] = dist[x][y] + 1;
						q.add(new P16948(nx,ny));
					}
				}
				
			}
			
		}
		
	}
}
