//백준 1644 소수의 연속합.
package codingTest2_1;

import java.io.*;
import java.util.*;

public class TwoPointer3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean check[] = new boolean[n+1];
		
		check[0] = check[1] = true; //true -> 소수아님
		ArrayList<Integer> p = new ArrayList<Integer>();
		
		for(int i=2; i*i<=n; i++) {
			if(!check[i]) {
				for(int j=i*i; j<=n; j+=i) {
					check[j] = true;
				}
			}
		}
		for(int i=0; i<=n; i++) {
			if(!check[i]) p.add(i);
		}
		
		int ans =0;
		int left = 0;
		int right = 0;
		int sum = 0;
		if(p.size() == 0) {
			sum = 0;
		}else {
			sum = p.get(0);
		}
		
		while(left<=right && right < p.size()) {
			if(sum < n) {
				right++;
				if(right < p.size()) 
					sum += p.get(right);	
				
			}else if(sum == n) {
				ans += 1;
				right++;
				if(right < p.size())
				sum += p.get(right);
			}else if(sum > n) {
				sum -= p.get(left);
				left++;
				if(left>right && left<=n) {
					right = left;
					sum = p.get(right);
				}
			}
		}
		
		System.out.println(ans);
	}
}
