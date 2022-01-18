import java.io.*;
import java.util.*;

public class Main {

	static class Node{
		int x;
		int y;
		int dist;
		int horse;
		Node(int x, int y, int dist, int horse){
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.horse = horse;
		}
	}
	
	static final int hx[] = {1, 2, 2, 1,-1,-2,-2,-1};
	static final int hy[] = {2, 1,-1,-2,-2,-1, 1, 2};
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	
	static int k,n,m,ans;
	static int[][] arr;
	static boolean[][][] visit;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
	
		arr = new int[n][m];
		visit = new boolean[n][m][31];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = -1;
		bfs();
		
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		visit[0][0][k] = true;
		q.add(new Node(0,0,0,k));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int x = now.x;
			int y = now.y;
			
			
			if(x == n-1 && y == m-1) {
				ans = now.dist;		
				return;
			}
			
			for(int k=0;k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(!visit[nx][ny][now.horse] && arr[nx][ny] == 0) {
						visit[nx][ny][now.horse] = true;
						q.add(new Node(nx,ny,now.dist+1, now.horse));
					}
				}			
			}	
			
			if(now.horse > 0) {
				
				for(int k=0; k<8; k++) {
					int nx = x + hx[k];
					int ny = y + hy[k];
					if(0<=nx && nx<n && 0<=ny && ny<m) {
						if(!visit[nx][ny][now.horse-1] && arr[nx][ny] == 0) {
							visit[nx][ny][now.horse-1] = true;
							q.add(new Node(nx,ny,now.dist+1, now.horse-1));
						}
					}
				}
				
			}
					
		}
	}
}
