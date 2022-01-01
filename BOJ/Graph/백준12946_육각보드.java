import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static final int dx[] = {-1,-1,0,0,1,1};
	static final int dy[] = {0,1,-1,1,-1,0};
	
	static char a[][];
	static int color[][];
	static int n,ans;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new char[n][n];
		color = new int[n][n];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				a[i][j] = s.charAt(j);
				color[i][j] = -1;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] == 'X' && color[i][j] == -1) {
					dfs(i,j,0);
				}
			}
		}
		System.out.println(ans);
	}
	
	static void dfs(int x,int y, int c) {
		color[x][y] = c;
		ans = Math.max(ans, 1);
		
		for(int k=0; k<6; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(0<=nx && nx < n && 0<= ny && ny <n) {
				if(a[nx][ny] == 'X') {
					if(color[nx][ny] == -1) {
						dfs(nx,ny, 1-c);
					}
					ans = Math.max(ans, 2);
					if(color[nx][ny] == c) {
						ans = Math.max(ans, 3);
					}
					
				}
			}
		}			
	}	
}
