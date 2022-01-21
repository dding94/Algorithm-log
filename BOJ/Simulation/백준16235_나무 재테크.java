package Simulation;

import java.util.*;
import java.io.*;

public class BOJ16235 {

    static final int[] dx = {-1,-1,-1,0,0,1,1,1};
    static final int[] dy = {-1,0,1,-1,1,-1,0,1};
   
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] a = new int[n][n]; //겨울에 추가 될 양분
		int[][] d = new int[n][n]; //양분
		ArrayList<Integer>[][] tree = new ArrayList[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				d[i][j] = 5;
				tree[i][j] = new ArrayList<>();
			}
		}
	
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			tree[x-1][y-1].add(age);
		}
		
		while(k -->0) {
			int[][] imsi = new int[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					ArrayList<Integer> temp = new ArrayList<>();
					Collections.sort(tree[i][j]);
					int dead = 0;
					
					for(int x : tree[i][j]) {
						if(x <= d[i][j]) {
							d[i][j] -= x; //양분을 먹음
							temp.add(x+1); //나이 증가
							if((x+1) % 5 == 0) {
								for(int l=0; l<8; l++) {
									int nx = i + dx[l];
									int ny = j + dy[l];
									if(0<=nx && nx <n && 0<=ny && ny<n){
										imsi[nx][ny] += 1;
									}
								}
							}
						}else {
							dead += x/2;
						}
					}
					tree[i][j] = temp;
					d[i][j] += dead;
					d[i][j] += a[i][j];
					
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					for(int l=0; l<imsi[i][j]; l++) {
						tree[i][j].add(1);
					}
				}
			}
			
			
		}	
		int ans =0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ans += tree[i][j].size();
			}
		}
		System.out.println(ans);
		
	}

}
