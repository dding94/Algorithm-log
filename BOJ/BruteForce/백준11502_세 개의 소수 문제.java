package 백준.PS8월;

import java.io.*;

public class PS0804_11502 {

	static boolean[] prime = new boolean[1001];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		setPrime();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			if (!makePrime(n)) {
				sb.append(0 + "\n");
			}
		}

		System.out.println(sb);
	}

	private static boolean makePrime(int n) {
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= n; j++) {
				for (int k = 2; k <= n; k++) {
					if ((!prime[i] && !prime[j] && !prime[k]) && i + j + k == n) {
						sb.append(i + " " + j + " " + k + "\n");
						return true;
					}
				}
			}
		}

		return false;
	}

	private static void setPrime() {
		prime[0] = prime[1] = true;

		for (int i = 2; i * i <= 1000; i++) {
			if (!prime[i]) {
				for (int j = i + i; j <= 1000; j += i) {
					prime[j] = true;
				}
			}
		}
	}
}
