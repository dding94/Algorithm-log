//백준 2206 벽 부수고 이동하기
import java.io.*;
import java.util.*;

class Pair{
	int x;
	int y;
	int dist;
	int boom;
	Pair(int x, int y, int dist, int boom){
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.boom = boom;
	}
}

public class Pair{

	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static int n,m,ans;
	static boolean visit[][][];
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m][2];
		ans = Integer.MAX_VALUE;

		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		bfs();
		
		System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
			
	}
	
	static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0,0,1,0));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			int x = now.x;
			int y = now.y;
			
			if(x==n-1 && y == m-1) {
				ans = now.dist;
				return;
			}
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(0>nx || nx>=n || 0>ny || ny>=m) continue;
				
				if(map[nx][ny] == 0 && !visit[nx][ny][now.boom]) {
					visit[nx][ny][now.boom] = true;
					q.add(new Pair(nx,ny,now.dist+1,now.boom));
				}else {
					if(now.boom == 0 && !visit[nx][ny][now.boom+1]) {
						visit[nx][ny][now.boom+1] = true;
						q.add(new Pair(nx,ny,now.dist+1,now.boom+1));
					}
				}
				
			}
		}
		
	}
}
