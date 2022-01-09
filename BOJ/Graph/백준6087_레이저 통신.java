import java.io.*;
import java.util.*;


class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static int n,m;
	static char[][] map;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		dist = new int[n][m];
		
		int sx,sy,ex,ey;
		sx=sy=ex=ey=0;
		
		boolean isC=false;
		
		for(int i=0; i<n ;i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j);
				dist[i][j] = -1;
				if(map[i][j] == 'C') {
					if(!isC) {
						sx = i;
						sy = j;
						isC = true;
					}else {
						ex = i;
						ey = j;
					}
				}
			}
		}
		
		bfs(sx,sy);
		
		System.out.println(dist[ex][ey] -1);
	}
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		dist[x][y] = 0;
		q.add(new Node(x,y));
		
		while(!q.isEmpty()) {
			Node p = q.poll();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				while(0<=nx && nx<n && 0<=ny && ny<m) {
					if(map[nx][ny] == '*') break;
					if(dist[nx][ny] == -1) {
						dist[nx][ny] = dist[x][y] + 1;
						q.add(new Node(nx,ny));
					}
					nx += dx[k];
					ny += dy[k];
				}
				
			}
		}
		
	}
}
