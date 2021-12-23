//πÈ¡ÿ 14499 ¡÷ªÁ¿ß ±º∏Æ±‚
package codingTest1_4;

import java.io.*;
import java.util.*;

public class simulation4 {

	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0}; //µø1 º≠2 ≥≤3 ∫œ4
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		int dice[] = new int[7];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		while(k-->0) {
			int cmd = Integer.parseInt(st.nextToken());
			cmd -= 1;
			
			int nx = x+dx[cmd];
			int ny = y+dy[cmd];
			
			if(0>nx || 0>ny || nx>=n || ny >= m) continue;
			
			switch(cmd) {
			case 0: //µø		
				int temp = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
				dice[6] = dice[3];
				dice[3] = temp;
				break;
			case 1: //º≠
				temp = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6];
				dice[6] = dice[4];
				dice[4] = temp;
				break;
			case 2: //≥≤
				temp = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[6];
				dice[6] = dice[5];
				dice[5] = temp;
				break;
			case 3: //∫œ
				temp = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
				dice[6] = dice[2];
				dice[2] = temp;
				break;
			default:
				break;
			}
			x = nx;
			y = ny;
			
			if(map[nx][ny] == 0) {
				map[nx][ny] = dice[6];
			}else {
				dice[6] = map[nx][ny];
				map[nx][ny] = 0;
			}
			
			sb.append(dice[1]).append('\n');
		}	
		System.out.println(sb);
	}
	
}
