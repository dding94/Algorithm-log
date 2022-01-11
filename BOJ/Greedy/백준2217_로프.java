import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int n = Integer.parseInt(br.readLine());
		Integer[] a = new Integer[n];
		
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(a,Collections.reverseOrder());

		int max =0;
		for(int i=0; i<n; i++) {
			if(a[i]*(i+1) > max) {
				max = a[i]*(i+1);
			}
		}
		
		System.out.println(max);
	}
}
