package 백준.PS8월;

import java.io.*;

public class PS0818_9081 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            char[] words = s.toCharArray();

            if (next_Permutation(words)) {
                for (char word : words) {
                    sb.append(word);
                }
                sb.append("\n");
            } else {
                sb.append(s + "\n");
            }
        }

        System.out.println(sb);
    }


    public static boolean next_Permutation(char a[]) {
        int i = a.length-1;

        while(i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;

        while(a[i-1] >= a[j]) {
            j--;
        }

        char temp = a[j];
        a[j] = a[i-1];
        a[i-1] = temp;

        j = a.length-1;

        while(i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}
