//백준 16926 배열 돌리기2
package codingTest1_4;

import java.io.*;
import java.util.*;

public class simulation3 {

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
		
		ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
		
		int groupCnt = Math.min(n, m)/2;
		
		for(int k=0; k<groupCnt; k++) {
			ArrayList<Integer> group = new ArrayList<>();
			for(int j=k; j<m-k ; j++) {	
				group.add(a[k][j]);
			}
			for(int i=k+1; i<n-k-1; i++) {
				group.add(a[i][m-k-1]);
			}
			for(int j=m-k-1; j>k ; j--) {
				group.add(a[n-k-1][j]);
			}
			for(int i=n-k-1; i>k; i--) {
				group.add(a[i][k]);
			}
			groups.add(group);
		}
		
		for(int k=0; k<groupCnt; k++) {
			ArrayList<Integer> group = groups.get(k);
			int len = group.size();
			int index = r % len;
			
			for(int j=k; j<m-k; j++, index = (index+1) % len) {
				a[k][j] = group.get(index);
			}
			for(int i=k+1; i<n-k-1; i++, index = (index+1) % len) {
				a[i][m-k-1] = group.get(index);
			}
			for(int j=m-k-1; j>k; j--, index = (index+1) % len) {
				a[n-k-1][j] = group.get(index);
			}
			for(int i=n-k-1; i>k; i--, index = (index+1) % len) {
				a[i][k] = group.get(index);
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sb.append(a[i][j]+" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
