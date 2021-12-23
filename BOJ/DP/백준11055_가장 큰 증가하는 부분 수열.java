//백준 11055 가장 큰 증가 부분 수열
package codingTest1_2;

import java.io.*;
import java.util.*;

public class dp_7 {

	static int d[];
	static int a[];

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		d = new int[n];
		a = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			d[i] = a[i];
		}
	
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(a[j] < a[i]) {
					d[i] = Math.max(d[i], d[j] + a[i]);					
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
