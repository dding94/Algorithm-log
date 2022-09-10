package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0910_1599 {

    //a b c d e f g h i j k l m n o p q r s t u v w x y z
    //a b k d e g h i l m n ng o p r s t u w y
    static String[] minsic = {"a", "b", "k", "d", "e", "g", "h", "i", "l", "m", "n","o", "p"};
    static String[] origin = {"a", "b", "c", "d", "e", "g", "h", "i", "l", "m", "n","o", "p"};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();

        while (n-- > 0) {
            String s = br.readLine();
            s = s.replaceAll("ng", "n~");

            for (int i = 0; i < minsic.length; i++) {
                s = s.replaceAll(minsic[i], origin[i]);
            }

            list.add(s);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            s = s.replaceAll("n~", "ng");

            for (int j = 0; j < minsic.length; j++) {
                s = s.replaceAll(origin[j], minsic[j]);
            }
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }

}
