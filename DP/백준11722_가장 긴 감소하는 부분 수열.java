//백준 11722 가장 긴 감소하는 부분 수열
package codingTest1_2;

import java.io.*;
import java.util.*;

public class dp_8 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		int d[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			d[i] = 1;
		}
			
			
		for(int i=n-1; i>=0; i--) {
			for(int j=i+1; j<n; j++) {
				if(a[i] > a[j] && d[i] < d[j] + 1) {
					d[i] = d[j] + 1;
				}
			}
		}
		int ans =0;
		for(int i=0; i<n; i++) {
			if(ans < d[i]) ans = d[i];
		}
		System.out.println(ans);
	}

}
