package Arrays;

/*

link : https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

주어진 2차원 배열 6 x 6 arr :

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

A에서의 모래 시계는 arr의 그래픽 표현에서
이 패턴에 속하는 인덱스를 갖는 값의 부분 집합으로 정의됩니다.

a b c
  d
e f g


arr에는 16 개의 모래 시계가 있고, 모래 시계 합계는 모래 시계 값의 합입니다.
arr의 모든 모래 시계에 대한 모래 시계 합계를 계산 한 다음 최대 모래 시계 합계를 인쇄하십시오.

예를 들어, 2D 배열이 주어진 경우 :

-9 -9 -9  1 1 1
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0

다음과 같은 16 개의 모래 시계 값을 계산합니다.

-63, -34, -9, 12,
-10, 0, 28, 23,
-27, -11, -2, 10,
9, 17, 25, 18

우리의 가장 높은 모래 시계 값은 모래 시계에서 28입니다 :

0 4 3
  1
8 6 6

Note :
Java 도메인의 Java 2D Array 챌린지를 이미 해결 한 경우
이 챌린지를 건너 뛰고 싶을 수 있습니다.

- 함수 설명

아래 에디터에서 hourglassSum 함수를 완성하십시오.
배열에서 최대 모래 시계 합계 인 정수를 반환해야합니다.

hourglassSum에는 다음과 같은 매개 변수가 있습니다.

arr : 정수 배열

- 입력 형식

입력의 6 줄 각각은 arr [i]에 6 개의 공백으로 구분 된 정수 arr[i][j]를 포함합니다.

- 제약 조건

-9 <= arr[i][j] <= 9
0 <= i,j <= 5

- 출력 형식

arr에서 발견되는 가장 큰(최대) 모래 시계 합계를 인쇄하십시오.

-----
- 입력 예제1

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

- 출력 예제1

19

- 예제1 설명

arr에는 다음과 같은 모래 시계가 들어 있습니다.

1 1 1  1 1 0  1 0 0  0 0 0
  1      0      0      0
1 1 1  1 1 0  1 0 0  0 0 0

0 1 0  1 0 0  0 0 0  0 0 0
  1      1      0      0
0 0 2  0 2 4  2 4 4  4 4 0

1 1 1  1 1 0  1 0 0  0 0 0
  0      2      4      4
0 0 0  0 0 2  0 2 0  2 0 0

0 0 2  0 2 4  2 4 4  4 4 0
  0      0      2      0
0 0 1  0 1 2  1 2 4  2 4 0


최대 합계 (19)가 있는 모래 시계는 다음과 같습니다.

2 4 4
  2
1 2 4

* */
public class Array2D {
    static int hourglassSum(int[][] arr) {
        int y = 0;
        int max = arr[0][0] + arr[0][1] + arr[0][2]
                + arr[1][1]
                + arr[2][0] + arr[2][1] + arr[2][2];
        while(y < 4) {
            for (int x=0; x<4; x++) {
                int top = arr[y][x] + arr[y][x+1] + arr[y][x+2];
                int mid = arr[y+1][x+1];
                int btm = arr[y+2][x] + arr[y+2][x+1] + arr[y+2][x+2];
                int total = top + mid + btm;

                System.out.println();
                System.out.println(arr[y][x]+" "+arr[y][x+1]+" "+arr[y][x+2]);
                System.out.println("  "+arr[y+1][x+1]+"  ");
                System.out.println(arr[y+2][x]+" "+arr[y+2][x+1]+" "+arr[y+2][x+2]);
                System.out.println("result : "+total);
                System.out.println();

                if (total > max) {
                    max = total;
                }
            }
            y++;
        }
        return max;
    }

    public void getResult() {
        int[][] data = {
                {1,1,1,0,0,0}
                ,{0,1,0,0,0,0}
                ,{1,1,1,0,0,0}
                ,{0,0,2,4,4,0}
                ,{0,0,0,2,0,0}
                ,{0,0,1,2,4,0}
        }; // 19

        int[][] data2 = {
                {-9,-9,-9,1,1,1}
                ,{0,-9,0,4,3,2}
                ,{-9,-9,-9,1,2,3}
                ,{0,0,8,6,6,0}
                ,{0,0,0,-2,0,0}
                ,{0,0,1,2,4,0}
        }; // 28

        int[][] data3 = {
                {0,-4,-6,0,-7,-6}
                ,{-1,-2,-6,-8,-3,-1}
                ,{-8,-4,-2,-8,-8,-6}
                ,{-3,-1,-2,-5,-7,-4}
                ,{-3,-5,-3,-6,-6,-6}
                ,{-3,-6,0,-8,-6,-7}
        }; // -19
        System.out.println(hourglassSum(data3));
    }
}
