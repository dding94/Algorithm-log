//벽 부수고 이동하기 2
import java.io.*;
import java.util.*;

public class PS0318_14442 {

	static class Node {
		int x;
		int y;
		int dist;
		int boom;

		public Node(int x, int y, int dist, int boom) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.boom = boom;
		}
	}

	static final int dx[] = {0, 0, 1, -1};
	static final int dy[] = {1, -1, 0, 0};
	static int[][] map;
	static boolean[][][] visit;
	static int n, m, k, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m][k+1];
		ans = -1;

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		bfs();

		System.out.println(ans);
	}
	static void bfs() {
		Queue<백준.PS3월.PS0318_14442.Node> q = new LinkedList<>();
		q.add(new 백준.PS3월.PS0318_14442.Node(0, 0, 1, k));
		visit[0][0][k] = true;

		while (!q.isEmpty()) {
			백준.PS3월.PS0318_14442.Node now = q.poll();

			int x = now.x;
			int y = now.y;

			if (x == n - 1 && y == m - 1) {
				ans = now.dist;
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (map[nx][ny] == 0 && !visit[nx][ny][now.boom]) {
						q.add(new 백준.PS3월.PS0318_14442.Node(nx, ny, now.dist + 1, now.boom));
						visit[nx][ny][now.boom] = true;
					}else{
						if (now.boom != 0 && !visit[nx][ny][now.boom - 1]) {
							q.add(new 백준.PS3월.PS0318_14442.Node(nx, ny, now.dist + 1, now.boom - 1));
							visit[nx][ny][now.boom - 1] = true;
						}
					}
				}
			}

		}
	}
}
