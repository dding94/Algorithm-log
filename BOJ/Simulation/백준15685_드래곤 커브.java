//백준 15685 드래곤 커브
package Practice;

import java.io.*;
import java.util.*;

public class bj15685 {						
	static final int dx[] = {1,0,-1,0};
	static final int dy[] = {0,-1,0,1};
	static boolean c[][] = new boolean[101][101];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int gen = Integer.parseInt(st.nextToken());
		
			ArrayList<Integer> dirs = dragon(dir,gen);
			c[x][y] = true;
			
			for(int d: dirs) {
				x += dx[d];
				y += dy[d];		
				c[x][y] = true;
			}
		}	
		
		int ans =0;
		for(int i=0; i<=99; i++) {
			for(int j=0; j<=99; j++) {
				if(c[i][j] && c[i][j+1] && c[i+1][j] && c[i+1][j+1]) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	
	static ArrayList<Integer> dragon(int dir, int gen) {
		ArrayList<Integer> ans = new ArrayList<>();
		
		ans.add(dir);
		for(int g=0; g<gen; g++) {			
			ArrayList<Integer> temp = new ArrayList<>(ans);
			Collections.reverse(temp); //전 세대 순서 반대
			for(int i=0; i<temp.size(); i++) {
				temp.set(i, (temp.get(i)+1) % 4); //
			}
			ans.addAll(temp);
		}
		return ans;
	}
}
