import java.io.*;
import java.util.*;

class Node{
	int x,y,dist,boom;
	Node(int x, int y, int dist, int boom){
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.boom = boom;
	}
}


public class Main {
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static int map[][];
	static boolean visit[][][];
	static int n,m,k,ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m][k+1];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) -'0';
			}
		}
		
		ans = -1;
	
		bfs();
	
		System.out.println(ans);
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,1,0));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Node p = q.poll();
			int x = p.x;
			int y = p.y;
			
			if(x == n-1 && y == m-1) {
				ans = p.dist;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(0>nx || nx >= n || 0 > ny || ny >= m) continue;
				
				
				if(map[nx][ny] == 0 && !visit[nx][ny][p.boom]) {
					visit[nx][ny][p.boom] = true;
					q.add(new Node(nx,ny,p.dist+1,p.boom));
				}else {
					if(p.boom<k && !visit[nx][ny][p.boom+1]) {
						visit[nx][ny][p.boom+1] = true;
						q.add(new Node(nx,ny,p.dist+1,p.boom+1));
					}
					
				}
			}
						
		}
	}

}
