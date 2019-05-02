package InterviewPreparationKit;

// link : https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen
/*

Emma는 연속적으로 번호가 매겨진 구름으로 시작하는 새로운 모바일 게임을 하고 있습니다.
구름의 일부는 천둥과 다른 것은 적운입니다.
그녀는 현재 구름 수에 1 또는 2를 더한 수의 적운 구름으로 뛰어 올 수 있습니다.
그녀는 천둥 소리를 피해야합니다.
Emma가 시작 지점에서 마지막 구름으로 점프하는 데 필요한 최소 점프 횟수를 결정합니다.
항상 게임에서이기는 것이 가능합니다.
각 게임에 대해 Emma는 안전한 경우 0의 번호가 매겨진 구름 배열을 얻습니다.
피할 수없는 경우 1을 만듭니다.
예를 들어, '0 ... 6'에서 인덱싱 된 c = [0, 1, 0, 0, 0, 1, 0]
각 구름의 숫자는 목록의 색인이므로 색인 1과 5에서 구름을 피해야합니다.
그녀는 0-> 2-> 4-> 6 또는 0-> 2-> 3-> 4-> 6의 두 가지 경로를 따를 수 있습니다.
첫 번째 경로는 3 번 점프하고 두 번째 경로는 4 번 점프합니다.

- 함수 설명

아래 편집기에서 jumpingOnClouds 함수를 완료하십시오.
그것은 필요한 점프의 최소 수를 정수로 반환해야합니다.

jumpingOnClouds에는 다음과 같은 매개 변수가 있습니다.

c : 2 진수의 배열

- 입력 형식

첫 번째 행에는 구름의 총 수인 정수 n이 포함됩니다.
두 번째 행에는 0 <= i <n 인 구름 c [i]를 설명하는
n 개의 공백으로 구분 된 2 진 정수가 들어 있습니다.

- 출력 형식

게임에서 이기기 위해 필요한 최소 점프 수를 인쇄하십시오.

- 제약 조건

2 <= n <= 100
c[i] ∈ {0,1}
c[0] = c[n-1] = 0

- 입력 예제 1
7
0 0 1 0 0 1 0

- 출력 예제 1
4

- 설명 1
Emma는 c[2]와 c[5]를 피해야합니다.
그녀는 최소 4 점프로 게임에서 이길 수 있습니다.

--

- 입력 예제 2
6
0 0 0 0 1 0

- 출력 예제 2
3

- 설명 2
피해야 할 유일한 뇌우는 c[4]입니다.
Emma는 3 점프로 게임에서 이길 수 있습니다.


* */
public class JumpingOnTheClouds {

    public int getResult(int[] c) {

        int jumpCnt = 0;
        int i = 0;
        int cLength = c.length;
        while (i != cLength-1) {
            System.out.println(i);

            if(c[i+1] == 1) {
                i += 2;
                System.out.println("JUMP : 1피함");
                jumpCnt++;
            } else {
                if ((i+2) <= cLength-1 && c[i+2] == 0) {
                    i += 2;
                    System.out.println("JUMP : 2단 점프");
                    jumpCnt++;
                } else if (c[i+1] == 0) {
                    i += 1;
                    System.out.println("JUMP : 1단 점프");
                    jumpCnt++;
                }
            }
        }

        return jumpCnt;
    }
}
