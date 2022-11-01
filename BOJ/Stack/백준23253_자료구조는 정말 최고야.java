package 백준.PS11월;

import java.io.*;

public class PS1101_23253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int m = Integer.parseInt(l[1]);

        boolean result = true;

        for (int i = 0; i < m; i++) {
            int c = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split(" ");
            int preVal = 200001;

            for (int j = 0; j < c; j++) {
                if (Integer.parseInt(split[j]) > preVal) {
                    result = false;
                }
                preVal = Integer.parseInt(split[j]);
            }
        }

        System.out.println(result ? "YES" : "NO");
    }

}
