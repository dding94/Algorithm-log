import java.io.*;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int cnt = 0;
        
        while(true) {
            int sum = 0;
            if(s.length() == 1) {
                break;
            }
            for(int i = 0; i < s.length(); i++) {
                sum += Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            cnt++;
            s = String.valueOf(sum);
        }
        
        System.out.println(cnt);
        if(Integer.parseInt(String.valueOf(s)) % 3 == 0) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}