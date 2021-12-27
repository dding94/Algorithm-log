//백준 10973 이전 순열

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		if(permutation(a)) {
			for(int i : a) {
				System.out.print(i + " ");
			}			
		}else System.out.println("-1");
		
	}

	static boolean permutation(int[] a) {
		int i = a.length-1;
		
		while(i>0 && a[i-1] <= a[i]) {
			i-=1;
		}
		
		if(i<=0) return false;
		
		int j = a.length-1;
		
		while(a[i-1] <= a[j]){
			j-=1;
		}
		
		int temp = a[j];
		a[j] = a[i-1];
		a[i-1] = temp;
		
		j = a.length-1;
		
		while(i<j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i+=1;
			j-=1;
		}
		
		return true;
	}
	
}
