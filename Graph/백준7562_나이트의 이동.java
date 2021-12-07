//백준 7562 나이트의 이동
package codingTest1_3;

import java.io.*;
import java.util.*;

class Pair7562{
	int x;
	int y;
	Pair7562(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class graph7 {

	static final int dx[] = {1, 2, 2, 1,-1,-2,-2,-1};
	static final int dy[] = {2, 1,-1,-2,-2,-1, 1, 2};
	static int map[][], dist[][];
	static int n;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			n = Integer.parseInt(br.readLine());
			dist = new int[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					dist[i][j] = -1;
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			bfs(x,y);
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			sb.append(dist[x][y]).append('\n');
		}
		
		System.out.println(sb);
	}

	static void bfs(int x, int y) {
		Queue<Pair7562> q = new LinkedList<>();
		q.add(new Pair7562(x,y));
		dist[x][y] = 0;
		
		while(!q.isEmpty()) {
			Pair7562 p = q.remove();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<8; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					if(dist[nx][ny] == -1) {
						q.add(new Pair7562(nx,ny));
						dist[nx][ny] = dist[x][y] + 1;
					}
				}
			}		
		}
		
	}
}
