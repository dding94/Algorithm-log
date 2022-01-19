import java.io.*;
import java.util.*;

public class Main {

	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
    final static int[] dx = {0,0,1,-1,1,1,-1,-1};
    final static int[] dy = {1,-1,0,0,1,-1,1,-1};
	static int n,m,ans;
    static int[][] map;
    static int[][] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					int dist = bfs(i,j);
					if(ans<dist) ans = dist;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static int bfs(int x,int y) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dist[i][j] = -1;
			}
		}
		
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		dist[x][y] = 0;

		while(!q.isEmpty()) {
			Node p = q.poll();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<8; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(0<=nx && nx< n && 0<=ny && ny < m) {
					if(dist[nx][ny] == -1) {
						if(map[nx][ny] == 1) {
							return dist[x][y] + 1;
						}else {
							q.add(new Node(nx,ny));
							dist[nx][ny] = dist[x][y] + 1;
						}
					}
				}
			}
			
		}
			
		return 0;
	}

}
