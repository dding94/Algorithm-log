//백준 16946 벽 부수고 이동하기 4
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

	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static int n,m,group;
	static int map[][], groupMap[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		groupMap = new int[n][m];
		group = 0;
		for(int i=0; i<n; i++){
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0 && groupMap[i][j] == 0) {
					group++;
					bfs(i,j);
				}
			}
		}
		
		int gCnt[] = new int[group];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++) {
				if(groupMap[i][j] != 0) {
					gCnt[groupMap[i][j]-1]++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) { 
					sb.append("0");
				}else { //벽인경우			
//					boolean gVisit[] = new boolean[group];
					HashSet<Integer> visit = new HashSet<>();
					int sum = 1;
					for(int k=0; k<4; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						
						if(0<=nx && nx<n && 0<=ny && ny<m) {
							if(map[nx][ny] == 0) {
								visit.add(groupMap[nx][ny]);
							}
						}					
					}
					for(int g :visit) {
						sum += gCnt[g-1];
					}
					sb.append(sum%10);				
				}						
			}
			sb.append('\n');
		}
		System.out.println(sb);
				
	}

	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		groupMap[x][y] = group;
		
		while(!q.isEmpty()) {
			Node p = q.poll();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(map[nx][ny] == 0 && groupMap[nx][ny] == 0) {
						q.add(new Node(nx,ny));
						groupMap[nx][ny] = group;
					}
				}
				
			}			
		}		
	}
}
