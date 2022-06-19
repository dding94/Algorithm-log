import java.io.*;
import java.util.*;

public class Main {
	static int n,m,k,ans,cnt;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static boolean[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new boolean[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u-1][v-1]=true;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visited[i][j] && map[i][j]) {
					cnt=0;
					bfs(i,j);
					ans = Math.max(ans, cnt);
				}
			}
		}
		System.out.println(ans);
		
	}

	private static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		visited[x][y] = true;
		cnt++;
        
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			for (int k = 0; k < 4; k++) {
				int nx = temp.x +dx[k];
				int ny = temp.y +dy[k];
				if(nx<0 || ny<0 || nx>=n || ny>=m)continue;
				if(!visited[nx][ny] && map[nx][ny]) {
					q.add(new Node(nx, ny));
					visited[nx][ny]=true;
					cnt++;
				}
			}
		}
	}

	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}