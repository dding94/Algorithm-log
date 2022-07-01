//비슷한 단어
package 백준.PS6월;

import java.io.*;

public class PS0701_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) - 1;

        String input = br.readLine();

        int ans = 0;
        while (n-- > 0) {
            char[] base = input.toCharArray();
            char[] comp = br.readLine().toCharArray();

            int temp = 0;

            for (int i = 0; i < comp.length; i++) {
                for (int j = 0; j < base.length; j++) {
                    if (comp[i] == base[j]) {
                        comp[i] = '1';
                        base[j] = '2';
                        temp++;
                    }
                }
            }

            //비교할 단어 대상이 원본보다 -1 이거나 == +1 인 3조건이 있음

            //1. 길이가 같을 경우  >> 원본 길이 == temp
            //2. 원본보다 길이가 1 작을 경우 >> input.size == temp
            //3. 원본보다 길이+1 경우  >> 원본 길이 == temp

            if (base.length == comp.length) {
                if (base.length == temp || base.length - 1 == temp) {
                    ans++;
                }
            }

            if (base.length - 1 == comp.length) {
                if (base.length - 1 == temp) {
                    ans++;
                }
            }

            if (base.length + 1 == comp.length) {
                if (base.length == temp) {
                    ans++;
                }
            }

        }

        System.out.println(ans);
    }
}
