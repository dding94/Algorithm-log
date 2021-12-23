//น้มุ 12851
package baekjoon;

import java.io.*;
import java.util.*;

public class bj12581 {
	
	static int time[];
	static int max = 200001;
	static int min = Integer.MAX_VALUE;
	static int cnt = 0;
	static int n,k;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		time = new int[max];
		
		for(int i=0; i<max; i++) {
			time[i] = -1;
		}
		
		bfs(n);
		if(n==k) {
			cnt = 1;
		}
		System.out.println(time[k]);
		System.out.println(cnt);
	}
	
	static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		time[n] = 0;
		
		while(!q.isEmpty()) {
			int now = q.remove();
			
			if(min < time[now]) return;
			
			int move[] = new int[] { now+1, now-1, now*2};
			
			for(int i=0; i<move.length; i++) {
				int next = move[i];
				
				if( next < 0 || max <= next) continue;
				
				if(next == k) {
					min = time[now];
					cnt++;
				}
				
				if(time[next] == -1 || time[next] == time[now]+1) {
					q.add(next);
					time[next] = time[now]+1;
				}
			}
			
		}
	}
}
	





