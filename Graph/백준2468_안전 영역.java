//백준 2468 안전 영역
package Practice;

import java.io.*;
import java.util.*;
class Pair2468{
	int x;
	int y;
	Pair2468(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class bj2468 {

	static final int dx[] = {0,0,-1,1};
	static final int dy[] = {1,-1,0,0};
	static int map[][], water[][];
	static boolean visit[][];
	static int n;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
	
		for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans =0;
		for(int k=0; k<101; k++) {
			int safezone = 0;
			water = new int[n][n];
			visit = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] <= k) {
						water[i][j] = -1;
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(water[i][j] != -1 && visit[i][j] == false) {
						safezone++;
						bfs(i,j);
					}
				}
			}
			if(ans < safezone) ans = safezone;
		}
		
		System.out.println(ans);

		
	}	
	static void bfs(int x, int y) {
		Queue<Pair2468> q = new LinkedList<>();
		q.add(new Pair2468(x,y));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			Pair2468 p = q.remove();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(0<=nx && nx<n && 0<=ny && ny <n) {
					if(visit[nx][ny] == false && water[nx][ny] == 0) {
						q.add(new Pair2468(nx,ny));
						visit[nx][ny] = true;
					}
				}				
			}			
		}
		
	}

}
