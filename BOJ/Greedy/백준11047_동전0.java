package Greedy;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Integer[] a = new Integer[n];
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(a,Collections.reverseOrder());		
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			if(k / a[i] != 0) {
				ans += k/a[i];
				k %= a[i];
			}
		}

		System.out.println(ans);
	}

}
