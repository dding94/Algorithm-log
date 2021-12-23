//백준 14226 이모티콘

package codingTest1_3;

import java.io.*;
import java.util.*;

class Pair14226{
	int x;
	int y;
	Pair14226(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BFS3 {
	
	static int time[][];
	static final int max = 1001;
	static int n;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		time = new int[max][max];
		
		for(int i=0; i<max; i++) {
			for(int j=0; j<max; j++) {
				time[i][j] = -1;
			}
		}
		bfs();
		
		int ans = -1;
		for(int i=0; i<=n; i++) {
			if(time[n][i] != -1) {
				if(ans == -1 || ans > time[n][i]) {
					ans = time[n][i];
				}
			}
		}
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Pair14226> q = new LinkedList<>();
		q.add(new Pair14226(1,0));
		time[1][0] = 0;
	
		
		while(!q.isEmpty()) {
			Pair14226 p = q.remove();
			int s = p.x; // screen
			int c = p.y; // clip
	
			if(time[s][s] == -1) {
				time[s][s] = time[s][c] +1;
				q.add(new Pair14226(s,s));
			}
			if(s+c<=n && time[s+c][c] == -1) {
				time[s+c][c] = time[s][c] +1;
				q.add(new Pair14226(s+c,c));
			}
			if(s-1 >=0 && time[s-1][c] == -1) {
				time[s-1][c] = time[s][c] +1;
				q.add(new Pair14226(s-1,c));
			}
			
		}
	}
}
