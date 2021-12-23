//πÈ¡ÿ 1260 DFSøÕ BFS
package codingTest1_3;

import java.io.*;
import java.util.*;

public class DFSandBFS {
	static ArrayList<Integer> a[];
	static boolean c[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		a = (ArrayList<Integer>[]) new ArrayList[n+1];
	
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a[u].add(v);
			a[v].add(u);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(a[i]);
		}
		
		c = new boolean[n+1];
		dfs(start);
		sb.append('\n');
		c = new boolean[n+1];
		bfs(start);
		System.out.println(sb);
		
	}

	public static void dfs(int x) {
		if(c[x]) return; 
		c[x] = true;
		sb.append(x).append(" ");
		
		for(int y: a[x]) {
			if(c[y] == false) {
				dfs(y);
			}
		}
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		c[start] = true;
		
		while(!q.isEmpty()) {
			int x = q.remove();
			sb.append(x).append(" ");
			for(int y:a[x]) {
				if(c[y] == false) {
					c[y] = true;
					q.add(y);
				}
			}
		}
	}
}
