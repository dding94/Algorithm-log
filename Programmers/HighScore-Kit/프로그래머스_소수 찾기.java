//프로그래머스 소수찾기
import java.util.HashSet;

class Solution {
	static boolean[] check;
	static HashSet<Integer> hs = new HashSet();

	public int solution(String numbers) {
		int answer = 0;
		check = new boolean[numbers.length()];

		for (int i = 0; i < numbers.length(); i++) {
			dfs(0, i + 1, "", numbers);
		}

		for (Integer number : hs) {
			if (checkPrime(number)) {
				answer++;
			}
		}
		System.out.println(answer);
		return answer;
	}

	static void dfs(int index,int depth, String result, String numbers) {
		if (index == depth) {
			if (result.charAt(0) != '0') {
				hs.add(Integer.valueOf(result));
			}
			return;
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (!check[i]) {
				check[i] = true;
				dfs(index + 1, depth, result + numbers.charAt(i), numbers);
				check[i] = false;
			}
		}
	}

	static boolean checkPrime(int number) {
		if (number < 2) {
			return false;
		}

		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}