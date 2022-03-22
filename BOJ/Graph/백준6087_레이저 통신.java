//레이저 통신
package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0322_6087 {

	static class Node{
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static final int dx[] = {0, 0, 1, -1};
	static final int dy[] = {1, -1, 0, 0};
	static int w, h;
	static char[][] map;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new char[h][w];
		dist = new int[h][w];
		boolean flag = false;
		int startX, startY, endX, endY;
		startX = startY = endX = endY = 0;

		for (int i = 0; i < h; i++) {
			String s = br.readLine();
			for (int j = 0; j < w; j++) {
				map[i][j] = s.charAt(j);
				dist[i][j] = -1;

				if(map[i][j] == 'C'){
					if(!flag){
						startX = i;
						startY = j;
						flag = true;
					}else{
						endX = i;
						endY = j;
					}
				}
			}
		}

		bfs(startX, startY);

		System.out.println(dist[endX][endY] - 1);
	}

	static void bfs(int x, int y) {
		Queue<백준.PS3월.PS0322_6087.Node> q = new LinkedList<>();
		q.add(new 백준.PS3월.PS0322_6087.Node(x, y));
		dist[x][y] = 0;

		while (!q.isEmpty()) {
			백준.PS3월.PS0322_6087.Node now = q.poll();
			x = now.x;
			y = now.y;

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				while (0 <= nx && nx < h && 0 <= ny && ny < w) {
					if (map[nx][ny] != '*') {
						if (dist[nx][ny] == -1) {
							dist[nx][ny] = dist[x][y] + 1;
							q.add(new 백준.PS3월.PS0322_6087.Node(nx, ny));
						}
					} else {
						break;
					}
					nx += dx[k];
					ny += dy[k];
				}
			}
		}
	}
}
