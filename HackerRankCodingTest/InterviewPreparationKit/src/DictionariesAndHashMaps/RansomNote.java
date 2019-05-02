package DictionariesAndHashMaps;

import java.util.HashMap;
import java.util.Hashtable;

/*

Hash Tables

link : https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

해롤드는 납치범으로 몸값을 쓴 유괴범이지만 지금은 자신의 필적을 통해 그에게 추적 될지 걱정된다.
그는 잡지를 발견하고 그것을 통해 모든 단어를 잘라내어 추적 할 수 없는 그의 몸값 기록을 만들 수 있는지 알고 싶어합니다.
노트에 있는 단어는 대소 문자를 구분하므로 잡지에서 사용 가능한 단어만 사용해야합니다.
하위 문자열이나 연결을 사용하여 필요한 단어를 만들 수 없습니다.

잡지의 단어와 몸값의 단어가 주어지면 잡지의 모든 단어를 정확하게 사용하여 몸값을 복제 할 수 있다면 Yes를 프린트하십시오.
그렇지 않으면 No를 프린트 합니다.

예를 들어, 메모는 "Attack at dawn"입니다.
잡지에는 "attak at dawn"만 포함됩니다.
잡지에는 모든 단어가 있지만 대소 문자가 일치하지 않습니다. 그래서 결과는 No 입니다.


- 함수 설명

아래 편집기에서 checkMagazine 함수를 완성하십시오.
잡지를 사용하여 메모를 작성할 수있는 경우 Yes를 프린트 해야합니다. 아닌경우 No를 프린트합니다.

checkMagazine에는 다음과 같은 매개 변수가 있습니다.

magazine : 문자열의 배열, 잡지의 각 단어
note : 문자열의 배열, 몸값의 각 단어


- 입력 형식

첫 번째 행에는 공백으로 구분 된 두 개의 정수 m과 n과 magazine의 단어 수와 note.
두 번째 줄에는 m개의 공백으로 구분 된 문자열이 들어 있으며 각 magazine[i]이 있습니다.
세 번째 줄에는 공백으로 구분 된 n 개의 문자열이 있으며 각 note[i]이 있습니다.


- 제약 조건

1 <= m,n <= 30000
1 <= managine[i], note[i] <= 5
각 단어는 영어 알파벳 문자 (즉, a ~ z 및 A ~ Z)로 구성됩니다.


- 출력 형식

잡지를 사용하여 추적 할 수없는 복제본을 만들 수 있다면 Yes를 프린트하세요. 그렇지 않으면 No를 프린트하세요.


- 샘플 입력 0

6 4
give me one grand today night
give one grand today

- 샘플 출력 0
Yes


- 샘플 입력 1

6 5
two times three is not four
two times two is four

- 샘플 출력 1
No

- 샘플 출력 1 설명
two는 잡지에서 한번만 발생하기 때문에 No 입니다.


- 샘플 입력 2

7 4
ive got a lovely bunch of coconuts
ive got some coconuts

- 샘플 출력 2
No

- 샘플 출력 2 설명
잡지에는 some이라는 단어가 없습니다. 때문에 출력은 No 입니다.

* */
public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        HashMap<String, Integer> magazineWords = new HashMap<>();

//        System.out.println(">>>> magazine setting");
        for(String m : magazine) {
//            System.out.println(m);

            int val = magazineWords.get(m) != null ? magazineWords.get(m) : 0;
//            System.out.println("val : "+m);

            if (val != 0) {
                magazineWords.replace(m, val + 1);
            } else {
                magazineWords.put(m, 1);
            }

        }

//        System.out.println(">>>> note check");
        boolean flag = true;
        for(String n : note) {
//            System.out.println(n);

            int val = 0;
            if (magazineWords.get(n) != null) {
                val = magazineWords.get(n);
            } else {
                System.out.println("No");
                flag = false;
                break;
            }

            if (val > 0) {
                magazineWords.replace(n, magazineWords.get(n) - 1);
            } else {
                System.out.println("No");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Yes");
        }
    }

    public void getResult() {

//        Yes
//        String[] magazine = "give me one grand today night".split(" ");
//        String[] note = "give one grand today".split(" ");

//        No
//        String[] magazine = "two times three is not four".split(" ");
//        String[] note = "two times two is four".split(" ");

        // No
        String[] magazine = "ive got a lovely bunch of coconuts".split(" ");
        String[] note = "ive got some coconuts".split(" ");
        checkMagazine(magazine, note);
    }
}
