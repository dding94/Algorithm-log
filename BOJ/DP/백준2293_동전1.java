//백준 2293 동전1
package baekjoon;

import java.io.*;
import java.util.*;

public class bj2293 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n];
		int d[] = new int[k+1];
		
		d[0] = 1; //아무것도 안쓰는것도 하나의 방법
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			for(int j=arr[i]; j<=k; j++) {
				d[j] += d[j - arr[i]];
			}
		}
		
		System.out.println(d[k]);
	}

}
