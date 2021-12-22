//¹éÁØ 1987 ¾ËÆÄºª
package baekjoon;
import java.io.*;
import java.util.*;

public class bj1987 {
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static int n,m,ans;
	static int a[][];
	static boolean alpha[] = new boolean[26];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				a[i][j] = s.charAt(j) - 'A';
			}
		}
		
		go(0,0,0);
		System.out.println(ans);
	}
	static void go(int x, int y, int cnt) {	
		if(alpha[a[x][y]]) {
			if(ans<cnt) ans = cnt;
			return;
		}else {
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					alpha[a[x][y]] = true;					
					go(nx,ny,cnt+1);
					alpha[a[x][y]] = false;			
				}
			}	
		}
	}
}
