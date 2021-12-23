//백준 7576 토마토
package codingTest1_3;
import java.io.*;
import java.util.*;

class Pair7576{
	int x;
	int y;
	Pair7576(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class graph6 {
	static final int dx[] = {0,0,-1,1};
	static final int dy[] = {1,-1,0,0};
	static int a[][], day[][];
	static int n,m ;
	static Queue<Pair7576> q;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		day = new int[n][m];		
		q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(a[i][j] == 1) {
					q.add(new Pair7576(i,j));
				}
			}
		}
		
		bfs();
		
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(ans < day[i][j]) ans = day[i][j];
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j] == 0 && day[i][j] == 0) {
					ans = -1;
				}
			}
		}
		System.out.println(ans);
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Pair7576 p = q.remove();
			int x = p.x;
			int y = p.y;
				
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(a[nx][ny] == 0 && day[nx][ny] == 0) {
						q.add(new Pair7576(nx,ny));
						day[nx][ny] = day[x][y] + 1;					
					}
				}
			}
		}
	}
}
