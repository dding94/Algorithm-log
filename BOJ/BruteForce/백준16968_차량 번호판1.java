import java.io.*;
import java.util.*;

public class Main {

	static int ans;
	static String s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();

		go(0,' ');

		System.out.println(ans);
	}

	static void go(int index, char last) {
		if(s.length() == index) {
			ans++;
			return;
		}

		char start = (s.charAt(index) == 'c' ? 'a' : '0');
		char end = (s.charAt(index) == 'c' ? 'z' : '9');
		int ans=0;

		for(char i=start; i<=end; i++) {
			if(i != last) {
				go(index+1, i);
			}
		}

	}
}
