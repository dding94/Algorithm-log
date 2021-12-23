//백준 1707 이분그래프
package codingTest1_3;

import java.io.*;
import java.util.*;

public class graph2 {
	
	static ArrayList<Integer> a[];
	static int visit[]; // 0: 미방문, 1: A그룹, 2: B그룹
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int k = Integer.parseInt(br.readLine());
		
		while(k-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // V
			int m = Integer.parseInt(st.nextToken()); // E
			
			visit = new int[n+1];
			a = (ArrayList<Integer>[]) new ArrayList[n+1];
			
			for(int i=1; i<=n; i++) {
				a[i] = new ArrayList<>();
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				a[u].add(v);
				a[v].add(u);
			}
			for(int i=1; i<=n; i++) {
				if(visit[i] == 0) {
					dfs(i, 1);
				}
			}
			boolean ok = true;
			
			for(int i=1; i<=n; i++) {
				for(int y: a[i]) {
					if(visit[i] == visit[y]) {
						ok = false;
						break; // 이미 이분그래프가 아니면 다음 검사할필요 X
					}
				}
			}
			
            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
		}
		
	}

	static void dfs(int x, int c) {
		visit[x] = c;
	
		for(int y: a[x]) {
			if(visit[y] == 0) {
				dfs(y, 3-c);
			}
		}
	}
}
