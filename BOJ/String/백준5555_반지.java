//반지
package 백준.PS5월;

import java.io.*;

public class PS0504_5555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n-- > 0) {
            String ring = br.readLine();
            ring += ring;

            if (ring.contains(input)) {
                count ++;
            }
        }

        System.out.println(count);
    }
}
