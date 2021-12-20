//백준 16197 두 동전
package codingTest2_1;

import java.io.*;
import java.util.*;

public class BruteForce6 {
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static int n,m;
	static char a[][];
	static int ans = Integer.MAX_VALUE;
	static int coin1_x, coin1_y, coin2_x, coin2_y;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new char[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				a[i][j] = s.charAt(j);
			}
		}
		int coin=0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j] == 'o') {
					coin++;
					if(coin == 1) {
						coin1_x = i;
						coin1_y = j;
					}
					if(coin == 2) {
						coin2_x = i;
						coin2_y = j;
					}
				}
			}
		}
		System.out.println(go(coin1_x, coin1_y, coin2_x, coin2_y,0));
		
	}
	static int go(int x1, int y1, int x2, int y2, int cnt) {	
		if(cnt == 11) return -1; //버튼 누른 횟수가 10회 이상
		boolean c1 = false;
		boolean c2 = false;
		
		if(0>x1 || x1>=n || 0>y1 || y1>=m) c1 = true; //동전1 떨어졌을때
		if(0>x2 || x2>=n || 0>y2 || y2>=m) c2 = true; //동전2 떨어졌을때
		if(c1 && c2) return -1; //둘다 떨어진 경우
		if(c1 || c2) return cnt; //하나만 떨어진 경우
		
		int ans = -1;
		for(int k=0; k<4; k++) {
			int nx1 = x1 + dx[k];
			int ny1 = y1 + dy[k];
			int nx2 = x2 + dx[k];
			int ny2 = y2 + dy[k];
			//벽일경우 이동 X
            if (0 <= nx1 && nx1 < n && 0 <= ny1 && ny1 < m && a[nx1][ny1] == '#') {
                nx1 = x1;
                ny1 = y1;
            }
            if (0 <= nx2 && nx2 < n && 0 <= ny2 && ny2 < m && a[nx2][ny2] == '#') {
                nx2 = x2;
                ny2 = y2;
            }
            int temp = go(nx1,ny1,nx2,ny2,cnt+1);
            if(temp == -1) continue;
            if(ans == -1 || ans>temp ) ans = temp;
		}
				
		return ans;
	}
}
