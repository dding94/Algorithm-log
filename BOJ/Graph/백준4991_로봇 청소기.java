import java.io.*;
import java.util.*;

public class Main {

	static class Node{
		int x;
		int y;

		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static char map[][];
	static int dist[][];
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if(n == 0 && m == 0) {
				System.out.println(sb);
				return;
			}
			
			map = new char[n][m];

			ArrayList<Node> dustZone = new ArrayList<>();

			for(int i=0; i<n; i++) {
				String s = br.readLine();
				for(int j=0; j<m; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == 'o') {
						dustZone.add(0, new Node(i,j));
					}
					if(map[i][j] == '*') {
						dustZone.add(new Node(i,j));
					}
				}
			}
				
			int l = dustZone.size();
			int[][] d = new int[l][l];
			boolean ok = true;
			
			for(int i=0; i<l; i++) {
				int[][] dist = bfs(dustZone.get(i).x, dustZone.get(i).y);
				for(int j=0; j<l; j++) {
					d[i][j] = dist[dustZone.get(j).x][dustZone.get(j).y];
					if(d[i][j] == -1) {
						ok = false;
					}
				}
			}

			if(ok == false) {
				sb.append(-1).append('\n');
				continue;
			}
			
			int[] p = new int[l-1];
			for(int i=0; i<l-1; i++) {
				p[i] = i+1;
			}
			int ans = -1;
			
			do {
				int now = d[0][p[0]];
				for(int i=0; i<l-2; i++) {
					now += d[p[i]][p[i+1]];
				}
				if(ans==-1 || ans > now) {
					ans = now;
				}
				
			}while(next_permutaiton(p));
			sb.append(ans).append('\n');
						
		}		
	}

	
	static int[][] bfs(int x, int y) {

		int[][] dist = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dist[i][j] = -1;
			}
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		dist[x][y] = 0;
		
		while(!q.isEmpty()) {
			Node p = q.poll();
			x = p.x;
			y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (dist[nx][ny] == -1 && map[nx][ny] != 'x') {
                        dist[nx][ny] = dist[x][y] + 1;
                        q.add(new Node(nx,ny));
                    }
                }
            }
		}
		
		
		return dist;		
	}		
	
	
	static boolean next_permutaiton(int[] a) {
		int i = a.length-1;
		
		while(i>0 && a[i-1] >= a[i]) {
			i -= 1;
		}
		
		if(i<=0) return false;
		
		int j = a.length-1;
		
		while(a[i-1] >= a[j]) {
			j -=1;
		}
		
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;
        j = a.length-1;
        
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
		
		return true;
	}
}
