//백준 13398 연속합2
package codingTest1_2;

import java.io.*;
import java.util.*;

public class dp_10 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		int d[] = new int[n]; // i번째에서 끝나는 최대 연속합
		int d2[] = new int[n]; // i번째에서 시작하는 최대 연속합
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		d[0] = a[0];
		for(int i=1; i<n; i++) {
			d[i] = d[i-1] + a[i];
			if(d[i-1] + a[i] < a[i]) {
				d[i] = a[i];
			}
		}
		
		d2[n-1] = a[n-1];
		for(int i=n-2; i>=0; i--) {
			d2[i] = d2[i+1] + a[i];
			if(d2[i+1] + a[i] < a[i]) {
				d2[i] = a[i];
			}
		}
		int ans = d[0]; // ans = -1001 로해도됨.
		
		
		//수 제거하지 않은 경우
		for(int i=0; i<n; i++) {
			if(ans < d[i]) {
				ans = d[i];
			}
		}
		//수 제거한 경우
		for(int i=1; i<n-1; i++) {
			if(ans < d[i-1] + d2[i+1]) {
				ans = d[i-1] + d2[i+1];
			}
		}
		
		System.out.println(ans);
	}

}
