package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS0131_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[10];

        char[] room = (br.readLine()).toCharArray();

        for (char c : room) {
            if (c == '6' || c == '9') {
                num[9]++;
            }else{
                num[c - '0']++;
            }
        }
        num[9] = num[9] / 2 + num[9] % 2;

        int ans =0;
        for(int i=0; i<num.length; i++){
            if (ans < num[i]) {
                ans = num[i];
            }
        }

        System.out.println(ans);
    }
}
