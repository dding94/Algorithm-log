//백준 14503 로봇 청소기
package codingTest1_4;

import java.io.*;
import java.util.*;

public class simulation6 {
	
					       //북 동 남 서
	static final int dx[] = {-1, 0, 1, 0};
	static final int dy[] = {0, 1 , 0 ,-1}; 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//-1 청소함 0 청소안함 1 벽
		while(true) {
			if(map[x][y] == 0) map[x][y] =-1;
			
			//네방향 청소가 되어있거나 벽인경우
			if(map[x+1][y] !=0 && map[x-1][y] !=0 && map[x][y+1] !=0 && map[x][y-1] !=0) {
				if(map[x-dx[d]][y-dy[d]] == 1) { //후진 할 곳이 벽
					break;					
				}else {
					x -= dx[d];
					y -= dy[d];
				}
			}else {
				//방향 좌측 회전
				d = (d+3) % 4;
				
				if(map[x+dx[d]][y+dy[d]] == 0) {
					x += dx[d];
					y += dy[d];
				}
			}
			
		}
			
		int ans =0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == -1) ans++;
			}
		}
		System.out.println(ans);
	}
}
