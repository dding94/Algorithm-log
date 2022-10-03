package 백준.PS10월;

import java.io.*;

public class PS1003_12927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean[] arr = new boolean[s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            arr[i + 1] = s.charAt(i) == 'Y';
        }

        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                continue;
            }
            cnt++;
            for (int j = i; j < arr.length; j += i) {
                arr[j] = !arr[j];
            }
        }

        System.out.println(cnt);
    }
}
