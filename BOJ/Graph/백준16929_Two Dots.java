import java.io.*;
import java.util.*;

public class Main{

	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static char a[][];
	static boolean check[][];
	static int n,m;
	static int firstX;
	static int firstY;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new char[n][m];
		check = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				a[i][j] = s.charAt(j);
			}
		}
	
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++){
				if(!check[i][j]) {
					firstX = i;
					firstY = j;
					if(dfs(i,j,0,a[i][j])) System.out.println("Yes");
					return;
				}	
			}
		}
		
		System.out.println("No");
	}
	
	static boolean dfs(int x, int y, int count, char color) {
		check[x][y] = true;
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(0<=nx && nx <n && 0<=ny && ny < m) {
				if(!check[nx][ny] && a[nx][ny] == color) {
					check[nx][ny] = true;
					if(dfs(nx,ny,count+1,color)) return true;
				}else {
					if(nx == firstX && ny == firstY && count >= 4) {
						return true;
					}
				}
			}
			
		}
		return false;
	}
	

}
