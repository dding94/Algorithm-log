//백준 1261 알고스팟
package codingTest1_3;

import java.io.*;
import java.util.*;

class Pair1261{
	int x;
	int y;
	Pair1261(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BFS5 {

	static final int dx[] = {0,0,-1,1};
	static final int dy[] = {1,-1,0,0};
	
	static int map[][];
	static int dist[][];
	static int n,m;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dist = new int[n][m];
		for(int i=0; i<n; i++) {
				String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
				dist[i][j] = -1;
			}
		}	
		bfs();
		
		System.out.println(dist[n-1][m-1]);
	}

	static void bfs() {
		Deque<Pair1261> q = new ArrayDeque<>();
		q.add(new Pair1261(0,0));
		dist[0][0] = 0;
		
		while(!q.isEmpty()) {
			Pair1261 p = q.poll();
			
			int x = p.x;
			int y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(0<=nx && nx<n && 0<=ny && ny < m) {
					if(dist[nx][ny] == -1) {
						if(map[nx][ny] == 0) {
							q.addFirst(new Pair1261(nx,ny));
							dist[nx][ny] = dist[x][y];
						}else {
							q.addLast(new Pair1261(nx,ny));
							dist[nx][ny] = dist[x][y]+1;
						}
					}
				}		
			}
		}
	}
}
