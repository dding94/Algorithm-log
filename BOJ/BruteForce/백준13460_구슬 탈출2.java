//백준 13460 구슬 탈출2
package Practice;

import java.io.*;
import java.util.*;

class Ball{
	int rx,ry;
	int bx,by;
	int cnt;
	Ball(int rx, int ry, int bx, int by, int cnt){
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
}

public class bj13460 {

	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static int n,m,holeX,holeY;
	static char a[][];
	static boolean visit[][][][];
	static Ball red,blue;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new char[n][m];
		visit = new boolean[n][m][n][m];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				a[i][j] = s.charAt(j);
				
				if(a[i][j] == 'R') red = new Ball(i,j,0,0,0);
				if(a[i][j] == 'B') blue = new Ball(0,0,i,j,0);
				if(a[i][j] == 'O') {
					holeX = i; 
					holeY = j; 
				}
			}
		}
		
		System.out.println(go());
		
	}
	static int go() {
		Queue<Ball> q = new LinkedList<>();
		q.add(new Ball(red.rx, red.ry, blue.bx, blue.by,1));
		visit[red.rx][red.ry][blue.bx][blue.by] = true;
		
		while(!q.isEmpty()) {
			Ball ball = q.poll();
			int nowRx = ball.rx;
			int nowRy = ball.ry;
			int nowBx = ball.bx;
			int nowBy = ball.by;
			int nowCnt = ball.cnt;
			
			if(nowCnt > 10) return -1;
			
			for(int k=0; k<4; k++) {
				int nextRx = nowRx; 
				int nextRy = nowRy;
				int nextBx = nowBx;
				int nextBy = nowBy;
				boolean isRedHole = false;
				boolean isBlueHole = false;
				
				//빨간공 이동
				while(a[nextRx+dx[k]][nextRy+dy[k]] != '#') {
					nextRx += dx[k];
					nextRy += dy[k];
					
					if(nextRx == holeX && nextRy == holeY) {
						isRedHole = true;
						break;
					}
				}
				while(a[nextBx+dx[k]][nextBy+dy[k]] != '#') {
					nextBx += dx[k];
					nextBy += dy[k];
					
					if(nextBx == holeX && nextBy == holeY) {
						isBlueHole = true;
						break;
					}
				}
				
				if(isBlueHole) continue;
				
				if(isRedHole && !isBlueHole) return nowCnt;
			
				if(nextRx == nextBx && nextRy == nextBy) {
					if(k==0) { // -> 방향
						if(nowRy < nowBy) nextRy -= dy[k];
						else nextBy -= dy[k];
					}
					if(k==1) { // <- 방향
						if(nowRy < nowBy) nextBy -= dy[k];
						else nextRy -= dy[k];
					}
					if(k==2) { // 아래
						if(nowRx < nowBx) nextRx -= dx[k];
						else nextBx -= dx[k];
					}
					if(k==3) { // 위
						if(nowRx < nowBx) nextBx -= dx[k];
						else nextRx -= dx[k];
					}
				}
				
				if(!visit[nextRx][nextRy][nextBx][nextBy]) {
					visit[nextRx][nextRy][nextBx][nextBy] = true;
					q.add(new Ball(nextRx,nextRy,nextBx,nextBy,nowCnt+1));
				}
				
			}
				
		}
		return -1;
	}
}
