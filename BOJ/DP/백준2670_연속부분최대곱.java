package 백준.PS12월;

import java.io.*;

public class PS1205_2670 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        double[] d = new double[n];
        double[] a = new double[n];

        for (int i = 0; i < n; i++) {
            a[i] = Double.parseDouble(br.readLine());
        }

        d[0] = a[0];

        for (int i = 1; i < n; i++) {
            double temp = d[i - 1] * a[i];
            d[i] = temp;

            if (temp < a[i]) {
                d[i] = a[i];
            }
        }

        double ans = -1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, d[i]);
        }

        System.out.println(String.format("%.3f", ans));

    }

}
