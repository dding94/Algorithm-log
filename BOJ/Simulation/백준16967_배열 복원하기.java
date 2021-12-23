//백준 16967 배열 복원하기
package codingTest1_4;


import java.io.*;
import java.util.*;

public class simulation12 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int a[][] = new int[h+x][w+y];
	

		for(int i=0; i<h+x; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w+y; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				a[i+x][j+y] -= a[i][j];
			}
		}

		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				sb.append(a[i][j] +" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
