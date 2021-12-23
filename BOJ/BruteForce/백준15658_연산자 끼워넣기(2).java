//백준 15658 연산자 끼워넣기 (2)
import java.io.*;
import java.util.*;

public class Main {

	static int a[];
	static int n;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int mul = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());
		
		go(1,a[0],plus,minus,mul,div);
		
		System.out.println(max);
		System.out.println(min);
	}
	static void go(int index, int cal, int plus, int minus, int mul, int div) {
		if(index == n ) {
			if(max < cal) max = cal;
			if(min > cal) min = cal;
			return;
		}
		
		if(plus != 0) go(index+1, cal+a[index], plus-1, minus, mul, div);
		if(minus != 0) go(index+1, cal-a[index], plus, minus-1, mul, div);
		if(mul != 0) go(index+1, cal*a[index], plus, minus, mul-1, div);
		if(div != 0) go(index+1, cal/a[index], plus, minus, mul, div-1);
	}
}
