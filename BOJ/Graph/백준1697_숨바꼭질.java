//백준 1697 숨바꼭질
package codingTest1_3;

import java.io.*;
import java.util.*;

public class BFS1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = 200000;
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int time[] = new int[max];
		boolean visit[] = new boolean[max];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		time[n] = 0;
		visit[n] = true;
		
		while(!q.isEmpty()) {
			int now = q.remove();
			if(0 <= now-1) {
				if(visit[now-1] == false) {				
					q.add(now-1);
					visit[now-1] = true;
					time[now-1] = time[now] + 1;
				}
			}
			
			if(now+1 < max) {
				if(visit[now+1] == false) {				
					q.add(now+1);
					visit[now+1] = true;
					time[now+1] = time[now] + 1;
				}
			}
			
			if(now*2 < max) {
				if(visit[now*2] == false) {
					q.add(now*2);
					visit[now*2] = true;
					time[now*2] = time[now] + 1;					
				}
			}
		}
		
		System.out.println(time[k]);
	}

}
