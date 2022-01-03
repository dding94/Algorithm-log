//백준 16928 뱀과 사다리 게임
import java.io.*;
import java.util.*;

public class Main {

	static int map[];
	static int dist[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new int[101];
		dist = new int[101];
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for(int i=1; i<=100; i++) {
			map[i] = -1;
			dist[i] = -1;
		}
		
		for(int i=0; i<n+m; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int nx = Integer.parseInt(st.nextToken());
			map[x] = nx;
		}
			
		bfs();
		
		System.out.println(dist[100]);
	}
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		dist[1] = 0;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=1; i<=6; i++) {
				int nx = x+i;
				if(nx>100) continue;	
				if(map[nx] > 0) {
					nx = map[nx];								
				}
				if(dist[nx] == -1) {
					dist[nx] = dist[x]+1;
					q.add(nx);
				}			
			}
		}
				
	}
}
