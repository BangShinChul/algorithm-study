package DictionariesAndHashMaps;

import java.util.*;

/*

link : https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps&h_r=next-challenge&h_v=zen


두 문자열이 주어지면 공통 부분 문자열을 공유하는지 확인하십시오.
하위 문자열은 한 문자만큼 작을 수 있습니다.

예를 들어, 단어 "a", "and", "art"는 공통 부분 문자열을 공유합니다.
"be"와 "cat"이라는 단어는 부분 문자열을 공유하지 않습니다.


- 함수 설명

아래의 편집기에서 function twoStrings를 완성하십시오.
문자열이 공통 부분 문자열을 공유하는지 여부에 따라 YES 또는 NO 중 하나의 문자열을 반환해야합니다.

twoStrings에는 다음과 같은 매개 변수가 있습니다.

s1, s2 : 분석 할 두 개의 문자열.


- 입력 형식

첫 번째 줄에는 테스트 케이스의 수인 단일 정수 p가 포함됩니다.

다음 p 쌍의 행은 다음과 같습니다.

첫 번째 행에는 s1 문자열이 있습니다.
두 번째 줄에는 s2 문자열이 있습니다.


- 제약 조건

s1과 s2는 ascii [a-z] 범위의 문자로 구성됩니다.

1 <= p <= 10
1 <= s1, s2 <= 100000


- 출력 형식

문자열 쌍마다 YES 또는 NO를 반환합니다.


- 샘플 입력

2
hello
world
hi
world

- 샘플 출력

YES
NO

- 해설

확인을 위해 p = 2 쌍이 있습니다.

s1 = "hello", s2 = "world". 하위 문자열 "o"와 "l"은 두 문자열에 공통적입니다.
a = "hi", b = "world". s1과 s2는 공통 부분 문자열을 공유하지 않습니다.


* */
public class TwoStrings {
    static String twoStrings(String s1, String s2) {
        HashSet<String> alphaSet = new HashSet<String>();

        // 97 ~ 122 a-z
        for (int i=97; i<123; i++) {
            String alphabet = Character.toString((char)i);
            if (s1.indexOf(alphabet) > -1) {
                alphaSet.add(alphabet);
            }
        }

        Iterator<String> iterator = alphaSet.iterator();
        checkLoop:
        while (iterator.hasNext()) {
            if (s2.indexOf(iterator.next()) > -1) {
                return "YES";
            }
        }
        return "NO";
    }



    public void getResult() {
        System.out.println(twoStrings("hello","world")); // YES
        System.out.println(twoStrings("hi","world")); // NO
    }

}
