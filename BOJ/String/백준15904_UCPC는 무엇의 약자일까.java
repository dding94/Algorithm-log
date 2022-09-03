import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ucpc = {'U', 'C', 'P', 'C'};
        int index = 0;

        String s = br.readLine();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ucpc[index]) {
                index++;
            }

            if(index == 4) {
                System.out.println("I love UCPC");
                return;
            }
        }
        
        System.out.println("I hate UCPC");
    }
}