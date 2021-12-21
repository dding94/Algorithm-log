//백준 16198 에너지 모으기
package codingTest2_1;

import java.io.*;
import java.util.*;

public class BruteForce7 {

	static ArrayList<Integer> w;
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		w = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			w.add(Integer.parseInt(st.nextToken()));
		}
		go(n, w, 0);
	
		System.out.println(ans);
	}
	static void go(int n, ArrayList<Integer> a,int sum) {
		if(n==2) {
			if(ans < sum) ans = sum;
			return;
		}
		
		for(int i=1; i<a.size()-1; i++) {
			int e = a.get(i-1) * a.get(i+1);
			int temp  = a.remove(i);
			go(n-1, a, sum+e);
			a.add(i,temp);
		}
		
	}

}
