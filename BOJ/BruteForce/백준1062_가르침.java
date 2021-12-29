//백준 1062 가르침
package codingTest2_1;

import java.io.*;
import java.util.*;

public class BitMask2 {

	static int n,k;
	static int max = Integer.MIN_VALUE;
	static String[] word;
	static boolean alpha[] = new boolean[26];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		word = new String[n];
		
		if(k<5) {
			System.out.println(0);
			return;
		}
		if(k==26){
			System.out.println(n);
			return;
		}
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			word[i] = s.substring(4,s.length()-4);
		}
		
		alpha['a' - 'a'] = true;
		alpha['n' - 'a'] = true;
		alpha['t' - 'a'] = true;
		alpha['i' - 'a'] = true;
		alpha['c' - 'a'] = true;

		go(0,0);
		System.out.println(max);
	}
	
	static void go(int index, int start) {
		if(index == k-5) {
			int count =0;
			
			for(int i=0; i<n ;i++) {
				boolean ok = true;
				for(int j=0; j<word[i].length(); j++) {
					if(!alpha[word[i].charAt(j) - 'a']) {
						ok = false;
						break;
					}
				}
				if(ok) count++;
			}
			max = Math.max(max, count);
			return;
		}
		
		for(int i=start; i<26; i++) {
			if(alpha[i] == false) {
				alpha[i] = true;
				go(index+1, i);
				alpha[i] = false;
			}
		}
		
	}
}

	

