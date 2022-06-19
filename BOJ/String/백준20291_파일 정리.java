import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new TreeMap<>();
		
		for (int i=0; i<n ;i++) {
			String input = br.readLine();
			String ext = input.substring(input.indexOf(".")+1);
			
            	if(map.containsKey(ext)) {
				int tmp = map.get(ext);
				map.replace(ext, ++tmp);
			} else {
				map.put(ext, 1);
			}
		}
		
		for(String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
	}

}