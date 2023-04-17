package 프로그래머스.연습문제

class ps0417_평균구하기 {

    class Solution {
        fun solution(arr: IntArray): Double {
            var answer = 0.0
            var temp = 0

            for (i in arr) {
                temp += i
            }

            answer = temp / arr.size.toDouble()

            return answer
        }
    }
}