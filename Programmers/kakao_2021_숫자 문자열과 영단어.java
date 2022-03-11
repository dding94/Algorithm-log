//재풀이 1

//방법 1
class Solution {
    public int solution(String s) {
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i  10; i++) {
            s = s.replaceAll(word[i], String.valueOf((i)));
        }

        int answer = Integer.parseInt(s);
        return answer;
    }
}

//방법 2
class Solution {
    public int solution(String s) {
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder sb = new StringBuilder();

        for (int pos = 0; pos < s.length(); ) {
            if (Character.isDigit(s.charAt(pos))) {
                sb.append(s.charAt(pos));
                pos++;
            }else{
                for (int i = 0; i < 10; i++) {
                    if (s.startsWith(word[i], pos )) {
                        sb.append(i);
                        pos += word[i].length();
                        break;
                    }
                }
            }
        }

        int answer = Integer.parseInt(sb.toString());
        return answer;
    }
}