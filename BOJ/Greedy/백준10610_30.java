
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		List<Integer> list = new ArrayList<>();
		
		int sum =0;
		for(int i=0; i<s.length(); i++) {
			sum += s.charAt(i) -'0';
			list.add(s.charAt(i) -'0');
		}
		
		Collections.sort(list);
		if(list.get(0) == 0 && sum % 3 == 0) {
			for(int i=list.size()-1; i>=0; i--) {
				System.out.print(list.get(i));
			}
		}else {
			System.out.println("-1");
		}
		
	}
}
