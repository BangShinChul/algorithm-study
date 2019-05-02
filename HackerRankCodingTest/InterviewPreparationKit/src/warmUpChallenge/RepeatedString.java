package warmUpChallenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*

link : https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

Lilah는 소문자 영문 문자 S를 사용하여 무한히 반복했습니다.
정수 N이 주어지면, 릴라의 무한한 문자열의 처음 N 글자에있는 문자 a의 수를 찾아서 인쇄하십시오.

예를 들어,
문자열 s = 'abcac'
n = 10 인 경우,
우리가 고려하는 부분 문자열은 abcacabcac입니다.

이 문자열은 무한한 문자열의 첫 번째 문자입니다.
하위 문자열에는 4 개의 항목이 있습니다.

- 함수 설명

아래 편집기에서 repeatedString 함수를 완성하십시오.
무한 반복 문자열에서 길이 N의 접두어에있는 a의 발생 수를 나타내는 정수를 반환해야합니다.

repeatedString에는 다음과 같은 매개 변수가 있습니다.

s : 반복 할 문자열
n : 고려해야 할 문자 수

- 입력 형식

첫 번째 줄에는 단일 문자열 S가 들어 있습니다.
두 번째 줄은 정수 N을 포함합니다.

- 제약 조건
1 <= S <= 100
1 <= N <= 10의 12승
테스트케이스의 25%에서 n <= 10의 6승 입니다.

- 출력 형식

S를 무한 반복 해 작성된 무한 문자열의 처음 N 문자에있는 문자 a의 수를 나타내는 단일 정수를 출력합니다.

---

- 샘플 입력1
aba
10

- 샘플 출력1
7

- 샘플1 해설
무한 문자열의 처음 n = 10 글자는 abaabaabaa입니다. 7 개의 a가 있기 때문에 새로운 행에 7을 인쇄합니다.

---

- 샘플 입력2
a
1000000000000

- 샘플 출력2
1000000000000

- 샘플2 해설
무한 문자열의 첫 번째 n = 1000000000000 문자는 모두 a이므로 새 줄에 1000000000000을 인쇄합니다.

* */
public class RepeatedString {
    static long repeatedString(String s, long n) {
        int sLength = s.length();
        long repeat = n%sLength > 0 ? n/sLength+1 : n/sLength; // 몫
        long diff = n%sLength; // 나머지

        System.out.println("repeat: "+repeat+" / diff: "+diff);

        if (sLength == 1 && s.equals("a")) {
            System.out.println("s: "+s+" / n: "+n);
            System.out.println("cnt: "+n);
            return n;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<repeat; i++) {
            if (diff > 0 && i == repeat-1) {
                int startAt = (int)(sLength-diff);
                sb.append(s.substring(startAt, sLength));
            } else {
                sb.append(s);
            }
        }

        Pattern p = Pattern.compile("a");
        Matcher m = p.matcher(sb);
        long cnt = 0;
        for (int r=0; m.find(r); r=m.end()) {
            cnt++;
        }

        System.out.println("s: "+s+" / n: "+n);
        System.out.println("sb: "+sb.toString());
        System.out.println("cnt: "+cnt);
        return cnt;
    }

    static long repeatedString2(String s, long n) {
        int sLength = s.length();
        long repeat = n/sLength; // 몫
        long diff = n%sLength; // 나머지

        System.out.println("==== repeat and diff and sLength ====");
        System.out.println(repeat+" / "+diff+" / "+sLength);

        if (sLength == 1 && s.equals("a")) {
            System.out.println(n);
            System.out.println("===================");
            return n;
        }

        Pattern p = Pattern.compile("a");
        Matcher m = p.matcher(s);
        long cnt = 0;
        for (int r=0; m.find(r); r=m.end()) {
            cnt++;
        }
        cnt = cnt * repeat;

        int startAt = (int)(sLength-diff);
        Matcher m2 = p.matcher(s.substring(startAt, sLength));
        long cnt2 = 0;
        for (int r2=0; m2.find(r2); r2=m2.end()) {
            cnt2++;
        }
        System.out.println(cnt);
        System.out.println(cnt2);
        cnt = cnt + cnt2;
        System.out.println(cnt);

        System.out.println("===================");

        return cnt;
    }

    static long repeatedString3(String s, long n) {
        long count = 0;

        if(n > s.length()) {
            long repeat = n/s.length();
            long diff = n % repeat;
            for(char c: s.toCharArray()) {
                if(c == 'a')
                    count++;
            }
            count = count * repeat;
            for(int i=0;i<diff;i++) {
                if(s.charAt(i) == 'a')
                    count++;
            }
        }
        else {
            int len = (int) n;
            s = s.substring(0,len+1);
            for(char c: s.toCharArray()) {
                if(c == 'a')
                    count++;
            }
        }
        System.out.println(count);
        return count;
    }

    static long repeatedString4(String s, long n) {
        int strLength = s.length();
        long aOccurrence = 0;
        long factor = n / strLength;
        long remainder = n % strLength;
        for (int i=0; i < strLength; i++) {
            if (s.charAt(i) == 'a') {
                aOccurrence += (i < remainder) ? factor + 1 : factor;
            }
        }
        System.out.println(aOccurrence);
        return aOccurrence;
    }

    public void getResult() {
        repeatedString4("aba", 10);
        repeatedString4("a", 1000000000000L);
        repeatedString4("aadcdaccacabdaabadadaabacdcbcacabbbadbdadacbdadaccbbadbdcadbdcacacbcacddbcbbbaaccbaddcabaacbcaabbaaa", 942885108885L); // result : 330009788107
    }
}
