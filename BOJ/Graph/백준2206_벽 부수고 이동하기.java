//백준 2206 벽 부수고 이동하기
package baekjoon;

import java.io.*;
import java.util.*;

class P2206{
	int x;
	int y;
	int dist;
	int boom;
	P2206(int x, int y,int dist, int boom){
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.boom = boom;
	}
}

public class bj2206 {
	
	static int n,m,ans;
	static int map[][], visit[][];
	static final int dx[] = {0,0,-1,1};
	static final int dy[] = {1,-1,0,0};
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new int[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		ans = Integer.MAX_VALUE;
		bfs();
		if(ans == Integer.MAX_VALUE) {
			System.out.println("-1"); return;
		}
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<P2206> q = new LinkedList<>();
		q.add(new P2206(0,0,1,0));
		visit[0][0] = 0; // 벽을 허물지 않은 상태
		
		while(!q.isEmpty()) {
			P2206 p = q.poll();
		
			int x = p.x;
			int y = p.y;
			
			if(x == n-1 && y == m-1) {
				ans = p.dist;
				return;
			}
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if( nx<0 || ny<0 || nx>=n || ny>=m ) continue;
				
				if(visit[nx][ny] <= p.boom) continue; //방문체크
				
				if(map[nx][ny] == 0) {//벽이 안막힌 경우
					visit[nx][ny] = p.boom;
					q.add(new P2206(nx,ny,p.dist+1,p.boom));
				}else {
					if(p.boom ==0) {
						visit[nx][ny] = p.boom+1;
						q.add(new P2206(nx,ny,p.dist+1,p.boom+1));						
					}
				}
				
			}
			
		}
		
	}
	
}

