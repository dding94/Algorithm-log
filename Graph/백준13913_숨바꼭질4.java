package codingTest1_3;

import java.io.*;
import java.util.*;

public class BFS2 {

	static int time[];
	static boolean visit[];
	static int v[];
	static int max = 200001;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		time = new int[max];
		visit = new boolean[max];
		v = new int[max];
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bfs(n);
		
		sb.append(time[k]).append('\n');
		
		go(k);
		
		System.out.println(sb);
	}

	static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		q.add(now);
		time[now] = 0;
		visit[now] = true;
		v[now] = -1;
		
		while(!q.isEmpty()) {
			now = q.remove();
			
			if(now-1>=0) {
				if(visit[now-1] == false) {
					q.add(now-1);
					visit[now-1] = true;
					time[now-1] = time[now] + 1;
					v[now-1] = now;
				}
			}
			if(now+1<max) {
				if(visit[now+1] == false) {
					q.add(now+1);
					visit[now+1] = true;
					time[now+1] = time[now] + 1;
					v[now+1] = now;
				}
			}
			if(now*2<max) {
				if(visit[now*2] == false) {				
					q.add(now*2);
					visit[now*2] = true;
					time[now*2] = time[now] + 1;
					v[now*2] = now;
				}
			}
		}
	}
	
	static void go(int n) {
		if(n == -1) return;
		
		go(v[n]);
		
		sb.append(n).append(" ");
	}
}
