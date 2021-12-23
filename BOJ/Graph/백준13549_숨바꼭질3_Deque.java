//백준 13549 숨바꼭질 3
package codingTest1_3;

import java.io.*;
import java.util.*;

public class BFS4_Deque {

	static int time[];
	static int max = 100000;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		time = new int[max];
		for(int i=0; i<max; i++) {
			time[i] = -1;
		}
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bfs(n);
		
		System.out.println(time[k]);
	}
	static void bfs(int n) {
		Deque<Integer> q = new ArrayDeque<>();
		q.add(n);
		time[n] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
	
			int move[] = {now+1 , now-1, now*2};
			
			for(int next: move) {			
				if(0<=next && next < max) {
					if(time[next] == -1) {
						if(next == now*2) {
							q.addFirst(next);
							time[next] = time[now];
						}else {
							q.addLast(next);
							time[next] = time[now]+1;
						}
					}				
				}			
			}
		}
		
	}
}
