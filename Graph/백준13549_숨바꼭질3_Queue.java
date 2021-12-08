//13549 숨바꼭질 3
package codingTest1_3;

import java.io.*;
import java.util.*;

public class BFS4_Queue {

	static int time[];
	static int max = 100001;
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
		Queue<Integer> q = new LinkedList<>(); // 가중치 0 저장
		Queue<Integer> Next_q = new LinkedList<>(); // 가중치 1 저장
		
		q.add(n);
		time[n] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			int move[] = {now+1, now-1, now*2};
			
			for(int i=0; i<3 ;i++) {
				int next = move[i];
				
				if(0<=next && next <max) {		
					if(next == now*2) {
						if(time[next] == -1) {
							q.add(next);
							time[next] = time[now];
						}
					}else {
						if(time[next] == -1) {
							Next_q.add(next);
							time[next] = time[now] + 1;
						}
					}
				}
			}
			
			if(q.isEmpty()) {
				q = Next_q;
				Next_q = new LinkedList<>();
			}
		}
	}
}
