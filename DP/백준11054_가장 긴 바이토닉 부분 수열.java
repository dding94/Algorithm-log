//백준 11054 가장 긴 바이토닉 부분 수열
package codingTest1_2;

import java.io.*;
import java.util.*;

public class dp_9 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		int d[] = new int[n]; //증가
		int d2[] = new int[n]; //감소
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			d[i] = 1;
			d2[i] = 1;
		}
		
		//i번째로 끝나는 부분수열
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(a[i] > a[j] && d[i]< d[j] + 1) {
					d[i] = d[j]+1;
				}
			}
		}
		//i번째에서 시작하는 부분수열
		for(int i=n-1; i>=0; i--) {
			for(int j=i+1; j<n; j++) {
				if(a[i]>a[j] && d2[i] < d2[j]+1) {
					d2[i] = d2[j] + 1;
				}
			}
		}
		int ans =0;
		for(int i=0; i<n; i++) {
			if(ans < d[i] + d2[i] -1) ans = d[i]+d2[i]-1;
		}
		System.out.println(ans);
	}

}
