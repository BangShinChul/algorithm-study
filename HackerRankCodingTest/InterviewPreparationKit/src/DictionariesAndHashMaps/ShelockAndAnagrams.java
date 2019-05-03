package DictionariesAndHashMaps;

import java.util.Arrays;

/*

link : https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps&h_r=next-challenge&h_v=zen

한 문자열의 문자가 다른 문자열을 형성하기 위해 재배치 될 수 있다면 두 개의 문자열은 서로의 아나그램입니다.
문자열이 주어지면, 문자열의 서로 다른 부분의 쌍의 수를 찾으십시오.

예를 들어, s = mom의 경우
모든 [[0],[2]], [[0],[1]], [[1],[2]] 위치에서 모든 anagrammatic 쌍의 목록은 [m, m], [mo, om] .


- 함수 설명

아래 편집기에서 sherlockAndAnagrams 함수를 완성하십시오.
s에있는 부분 문자열의 anagrammatic 쌍의 수를 나타내는 정수를 반환해야합니다.

sherlockAndAnagrams에는 다음 매개 변수가 있습니다.

s: 문자열


- 입력 형식

첫 번째 줄에는 쿼리의 수인 정수 q가 포함됩니다.
다음 q줄마다 분석 할 문자열 s가 들어 있습니다.


- 제약 조건

1 <= q <= 10
2 <= s <= 100

문자열 s는 오로지 소문자 ascii[a-z]만 포함됩니다.
s ∈ ascii[a-z]

- 출력 형식

각 쿼리에 대해 순서가 지정되지 않은 분석 쌍의 수를 반환합니다.


- 샘플 입력 0
2
abba
abcd

- 샘플 출력 0
4
0

- 샘플 0 해석

첫번째 입력값 'abba'에서는 [a,a], [ab,ba], [b,b], [abb,bba]의 4쌍의 아나그램 쌍이 나오고
위치는 각각 [[0],[3]], [[0,1],[2,3]], [[1],[2]], [[0,1,2],[1,2,3]]으로 총 4개가 나옵니다.

두번째 입력값 'abcd'는 문자가 반복되지 않기 때문에 아나그램 쌍이 존재하지 않습니다.


- 샘플 입력 1
2
ifailuhkqq
kkkk

- 샘플 출력 1
3
10

- 샘플 1 해석
첫번째 입력값 'ifailuhkqq'에서는 [i,i], [q,q], [ifa,fai]의

* */
public class ShelockAndAnagrams {
    static int sherlockAndAnagrams(String s) {

        char[] sArr = s.toCharArray();



    }

    public void getResult() {
        System.out.println(sherlockAndAnagrams("abba")); // 4
        System.out.println(sherlockAndAnagrams("ifailuhkqq")); // 4
        System.out.println(sherlockAndAnagrams("kkkk")); // 10
    }
}
