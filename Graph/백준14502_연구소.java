//백준 14502 연구소
package Practice;

import java.io.*;
import java.util.*;

class Pair14502{
	int x;
	int y;
	Pair14502(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class bj14502 {
	static final int dx[] = {0,0,-1,1};
	static final int dy[] = {1,-1,0,0};
	static int n, m;
	static int ans=0;
	static int map[][], wall[][];
	static int virus[][];
	static boolean c[][];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m]; //원본
		wall = new int[n][m]; //벽 세울곳
		virus = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		wall = map;
		
		dfs(0);
		
		System.out.println(ans);
	}
	
	static void dfs(int depth) {
		if(depth == 3) {
			bfs();	
			return;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(wall[i][j] == 0) {
					wall[i][j] = 1;
					dfs(depth+1);
					wall[i][j] = 0;
				}
			}
		}
	}
	static void bfs() {
		
		Queue<Pair14502> q = new LinkedList<>();
		
		//virus = wall 이 안되는 이유? == 주소값을 넘겨줌
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				virus[i][j] = wall[i][j];  
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(virus[i][j] == 2) {
					q.add(new Pair14502(i,j));					
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pair14502 p = q.remove();
			int x = p.x;
			int y = p.y;
			
			for(int k=0; k<4; k++) {
				
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(virus[nx][ny] == 0) {
						virus[nx][ny] = 2;
						q.add(new Pair14502(nx, ny));
					}				
				}		
			}
			
		}
		int safezone = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(virus[i][j] == 0) {
					safezone += 1;
				}
			}
		}
		if(ans < safezone) {
			ans = safezone;
		}	
	}
}
