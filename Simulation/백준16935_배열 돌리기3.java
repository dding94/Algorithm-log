//백준 16935 배열 돌리기3
package codingTest1_4;

import java.io.*;
import java.util.*;

public class simulation1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int a[][] = new int[n][m];		

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		while(r-->0) {
			int start = Integer.parseInt(st.nextToken());
			
			switch(start) {
			case 1: a = simulation1(a);
				break;
			case 2: a = simulation2(a);
				break;
			case 3: a = simulation3(a);
				break;
			case 4: a = simulation4(a);
				break;
			case 5: a = simulation5(a);
				break;
			case 6: a = simulation6(a);
				break;
			default:
				break;
			}
			
		}
		n = a.length;
		m = a[0].length;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sb.append(a[i][j] + " ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	//상하반전
	static int[][] simulation1(int a[][]) {
		int n = a.length;
		int m = a[0].length;
		
		int ans[][] = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				ans[i][j] = a[n-i-1][j];
			}
		}
		return ans;
	}
	//좌우반전
	static int[][] simulation2(int a[][]) {
		int n = a.length;
		int m = a[0].length;
		
		int ans[][] = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				ans[i][j] = a[i][m-j-1];
			}
		}
		return ans;
	}
	//오른쪽 90도 회전
	static int[][] simulation3(int a[][]) {
		int n = a.length;
		int m = a[0].length;
		
		int ans[][] = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				ans[i][j] = a[n-j-1][i];
			}
		}
		return ans;
	}
	//왼쪽 90도 회전
	static int[][] simulation4(int a[][]) {
		int n = a.length;
		int m = a[0].length;
		
		int ans[][] = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				ans[i][j] = a[j][m-i-1];
			}
		}
		return ans;
	}
	//1->2 2->3 3->4 4->1
	static int[][] simulation5(int a[][]) {
		int n = a.length;
		int m = a[0].length;
		
		int ans[][] = new int[n][m];
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<m/2; j++) {
				ans[i][j+m/2] = a[i][j];
				ans[i+n/2][j+m/2] = a[i][j+m/2];
				ans[i+n/2][j] = a[i+n/2][j+m/2];
				ans[i][j] = a[i+n/2][j];
			}
		}
		return ans;
	}
	//1->4 4->3 3->2 2->1
	static int[][] simulation6(int a[][]) {
		int n = a.length;
		int m = a[0].length;
		
		int ans[][] = new int[n][m];
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<m/2; j++) {
				ans[i+n/2][j] = a[i][j];
				ans[i][j] = a[i][j+m/2];
				ans[i][j+m/2] = a[i+n/2][j+m/2];
				ans[i+n/2][j+m/2] = a[i+n/2][j];
			}
		}
		return ans;
	}

}
