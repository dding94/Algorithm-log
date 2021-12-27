//백준 2529 부등호
import java.io.*;
import java.util.*;

public class Main {
	static char[] c;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		c = new char[k];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			c[i] = st.nextToken().charAt(0);
		}

		int[] big = new int[k+1];
		int[] small = new int[k+1];
		
		for(int i=0; i<k+1; i++) {
			big[i] = 9-i;
			small[i] = i;
		}
		
		do {
			if(check(small)) break;
		}while(next_permutation(small));
		
		do {
			if(check(big)) break;
		}while(prev_permutation(big));
		
		for(int a:big) {
			System.out.print(a);
		}
		System.out.println();
		for(int a:small) {
			System.out.print(a);
		}

	}
	static boolean check(int[] arr) {
		for(int i=0; i<c.length; i++){
			if(c[i] == '<' && arr[i] > arr[i+1]) return false;
			if(c[i] == '>' && arr[i] < arr[i+1]) return false;
		}
		return true;
	}

	static boolean next_permutation(int[] a) {
		int i = a.length-1;
		
		while(i>0 && a[i-1] >= a[i]) {
			i-=1;
		}
		
		if(i<=0) return false;
		
		int j = a.length-1;
		
		while(a[i-1] >= a[j]) {
			j-=1;
		}
		
		int temp = a[j];
		a[j] = a[i-1];
		a[i-1] = temp;
		
		j = a.length-1;
		while(i<j) {
			temp = a[j];
			a[j] = a[i];
			a[i] = temp;
			i+=1;
			j-=1;
		}
		
		return true;
	}
	
	static boolean prev_permutation(int[] a) {
		int i = a.length-1;
		
		while(i>0 && a[i-1] <= a[i]) {
			i-=1;
		}
		
		if(i<=0) return false;
		
		int j = a.length-1;
		
		while(a[i-1] <= a[j]) {
			j-=1;
		}
		
		int temp = a[j];
		a[j] = a[i-1];
		a[i-1] = temp;
		
	
		j = a.length-1;
		while(i<j) {
			temp = a[j];
			a[j] = a[i];
			a[i] = temp;
			i+=1;
			j-=1;
		}
		
		return true;
	}
}
