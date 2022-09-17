package 백준.PS9월;

import java.io.*;
import java.util.Arrays;

public class PS0917_1076 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] color = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        long result = (Arrays.asList(color).indexOf(a) * 10) + Arrays.asList(color).indexOf(b);

        result *= Math.pow(10, Arrays.asList(color).indexOf(c));

        System.out.println(result);
    }

}
