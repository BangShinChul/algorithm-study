import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
* https://www.hackerrank.com/challenges/string-function-calculation/problem
* */

/*

Jane은 무엇보다 문자열을 좋아합니다.
그녀는 그녀와 함께 문자열 T를 가지며,
함수 F에 대한 문자열 S의 값은 다음과 같이 계산 될 수 있습니다.

F(s) = 문자열 길이 * t에서 s가 발생한 횟수

Jane은 문자열 t의 모든 하위 문자열들
중에서 F(s)의 최대 값을 알고 싶어합니다.
그녀를 도울 수 있습니까?

입력 형식
문자열 t가 포함 된 한 줄.

출력 형식
String t의 모든 부분 문자열 중에서 F(s)의 최대 값을 인쇄합니다.

제약 조건
1 <= t <= 10의 5승(100000)
String은 알파벳 소문자로 구성됩니다.

----------

0번 샘플 입력
aaaaaa

0번 샘플 출력
12

0번 설명
f ('a') = 6
f ('aa') = 10
f ('aaa') = 12
f ('aaaa') = 12
f ('aaaaa') = 10
f ('aaaaaa') = 6

----------

1번 샘플 입력
abcabcddd

1번 샘플 출력
9

1번 설명
f ('a') = 2
f ('b') = 2
f ('c') = 2
f ('ab') = 4
f ('bc') = 4
f ('ddd') = 3
f ('abc') = 6
f ('abcabcddd') = 9

* */

// console.log("abcdefg".match(/[gfdecsb]/gi).length); <-- 문자열에서 특정 문자의 갯수를 리턴해주는 정규식 by js
public class Solution {

    // Complete the maxValue function below.
    static int maxValue(String t) {
        // 문자열 길이 값
        // 문자열 갯수 값

        // 문자열 길이 값 * 문자열 갯수 값 이므로
        // 제일 긴 문자열부터 검사
        // 맨끝 문자열을 하나씩 제거하면서 set을 통해 형태소 분석
        // 그 때 문자열 길이 값 * 문자열 갯수 값이 그 이전의 값보다 크면 업데이트
        // 아니면 버림
        //
        //

        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String t = scanner.nextLine();

        int result = maxValue(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
