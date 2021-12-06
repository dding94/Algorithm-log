//백준 11724 연결 요소의 개수
package codingTest1_3;

import java.io.*;
import java.util.*;

public class graph1 {
	static ArrayList<Integer> a[];
	static boolean c[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		a = (ArrayList<Integer>[]) new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		c = new boolean[n+1];
		
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a[u].add(v);
			a[v].add(u);
		}
		int ans = 0;
		for(int i=1; i<=n; i++) {
			if(c[i] == false) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);

	}
	static void dfs(int x) {
		if(c[x]) return;
		c[x] = true;
		
		for(int y:a[x]) {
			if(c[y] == false) {
				dfs(y);
			}
		}	
	}

}
