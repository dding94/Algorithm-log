import java.io.*;
import java.util.*;

class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main{

	static final int[] dx = {0,1,0,-1,0,1,-1,-1,1};
	static final int[] dy = {0,0,1,0,-1,1,1,-1,-1};
	static int n = 8, ans;
	static boolean visit[][];
	static char map[][];
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[n][n];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n ;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		ans = 0;
		bfs();
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(7,0));

		while(!q.isEmpty()) {
			
			int qSize = q.size();		
			for(int i=0; i<qSize; i++) {				
				Node p = q.poll();
				int x = p.x;
				int y = p.y; //현재좌표
				
				if(map[x][y] == '#') continue;
				
				for(int k=0; k<9; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					
					if(0<=nx && nx<n && 0<=ny && ny<n) {
						if(nx == 0 && ny == 7) {
							ans= 1;
							return;
						}
						
						if(map[nx][ny] != '#') {	
							q.add(new Node(nx,ny));
						}
					}
				}
			}
			down();
		}
		
	}
	static void down() {
		for(int i=7; i>=0; i--) {
			for(int j=7; j>=0; j--) {
				if(i-1<0) map[i][j] = '.';
				else map[i][j] = map[i-1][j];				
			}
		}
	}

}
