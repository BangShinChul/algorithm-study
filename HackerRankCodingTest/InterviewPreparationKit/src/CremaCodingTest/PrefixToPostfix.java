package CremaCodingTest;

import java.util.*;

/*

우리는 방정식 A + B * C + D에 대해 각각 수학 식에 대한 다음 용어를 정의합니다.

표기법         기술                                            예
Infix        표기법은 일반적으로 산술 수식을 표현하는 데 사용됩니다.      A + B * C + D
Prefix       연산자를 피연산자의 앞 (왼쪽)에 배치하는 표기법.           + + A * B C D
Postfix      연산자를 피연산자의 뒤에 (오른쪽으로) 배치하는 표기법.       A B C * + D +

다음 2진 연산자의 연산자 우선 순위를 가장 높은 값에서 가장 낮은 값으로 정의합니다.

1. 부문 : /
2. 곱셈 : *
3. 추가 : +
4. 뺄셈 : -


설명:

접두사 표기법에서 연산자는 두 개의 피연산자 바로 앞에옵니다.
이 경우 가장 높은 우선 순위는 곱셈입니다. B*C는 *BC로 다시 쓸 수 있습니다.
우리는 이것을 + A * BC로 쓰고 A에 더하고 이것을 D : ++ A * BCD에 더한다.

후위 (postfix) 표기법에서 연산자는 두 개의 피연산자 바로 다음에옵니다.
접두사 표기법에서와 마찬가지로 우선 순위가 가장 높습니다.
B*C는 BC*로 기록됩니다.
이제 A : ABC * +를 추가하고 마지막으로 D : ABC * + D +에 모두 추가하십시오.

- 맞춤 테스트 용 입력 형식

stdin으로부터의 입력은 다음과 같이 처리되고 함수로 전달됩니다.

첫 번째 줄에는 배열 접두사의 크기 인 정수 n이 포함됩니다.
다음 n 줄은 각각 0 <= i < n 인 요소 prefixes[i]를 포함합니다.

- 함수 설명
아래 편집기에서 prefixToPostfix 함수를 완성하십시오.
이 함수는 postfix 표현식의 배열을 반환해야합니다. 각 접두사는 주어진 순서대로 [i]에 대한 것입니다.

prefixToPostfix에는 다음과 같은 매개 변수가 있습니다.
prefixes[prefixes[0], ... prefixes[n-1]] : prefix 표현식의 배열

- 제약 조건
1 <= n <= 15
3 <= prefixes[i] <= 100000
각 prefixes[i]는 1자리 정수 피연산자 (1 ~ 9) 및 2진 연산자(/,*,+,-)로 구성된다.

- 샘플 입력 0
3
*34
+1*23
+12

- 샘플 출력 0
34*
123*+
12+

- 샘플 해설 0
다음 n = 3 표현식을 평가합니다.

0. prefix 표현식 *34의 중위 표현식은 3*4이고 중위 표현식 3*4에 대한 postfix 표현식은 34* 입니다.

1. prefix 표현식 +1*23의 중위 표현식은 1+2*3이고
중위 표현식 1+2*3에 대한 postfix 표현식은 123*+ 입니다.

2. prefix 표현식 +12의 중위 표현식은 1+2이고 중위 표현식 1+2에 대한 postfix 표현식은 12+ 입니다.

즉, 정답으로 postfix 표현식 배열[34*, 123*+, 12+]을 반환합니다.


- 샘플 입력 1
1
+1**23/14

- 샘플 출력 1
123*14/*+

- 샘플 해설 1
다음 n = 1 표현식을 평가합니다.

prefix 표현식 +1**23/14의 중위 표현식은 1+2*3*1/4 이고
중위 표현식 1+2*3*1/4 에 대한 postfix 표현식은 123*14/*+입니다.

즉, 정답으로 postfix 표현식 배열[123*14/*+]을 반환합니다.

+1**23/14
+1**2314/ -> /14의 /를 14의 뒤로
+1*23*14/ -> *23의 *을 23의 뒤로
+123*14/* -> *23*14/의 *을 23*14/의 뒤로
123*14/*+ -> +1의 +를 1의 뒤로


* */

public class PrefixToPostfix {

    public static boolean isOperator(char item) {
        switch (item){
            case '+' :
            case '-' :
            case '*' :
            case '/' :
                return true;
        }
        return false;
    }

    public static List<String> prefixToPostfix(List<String> prefixes) {

        List<String> result = new ArrayList<String>();
        Iterator<String> itr = prefixes.iterator();
        while (itr.hasNext()) {
            Stack<String> stack = new Stack<String>();
            String item = itr.next();
            int itemLength = item.length();

            for (int i=itemLength-1; i>=0; i--) {
                if (isOperator(item.charAt(i))) {
                    // 만약 현재 인덱스의 char가 연산자일 경우
                    // 앞의 두 인자를 뽑아낸 다음
                    String it1 = stack.peek();
                    stack.pop();
                    String it2 = stack.peek();
                    stack.pop();

                    // 연산자를 인자들의 뒤로 이동한다.
                    String temp = it1 + it2 + item.charAt(i);
                    stack.push(temp); // 그리고 다시 stack에 push한다.
                } else {
                    // 현재 인덱스의 char가 연산자가 아닐 경우
                    // 현재 인덱스의 숫자를 stack에 push한다.
                    stack.push(item.charAt(i)+"");
                }
            }
            System.out.println("result : "+stack.peek());
            result.add(stack.peek());
        }

        return result;
    }

    public static List<String> prefixToPostfix2(List<String> prefixes) {

        List<String> result = new ArrayList<String>();

        for(String prefix : prefixes){
            Stack<String> stack = new Stack<String>();

            int itemLength = prefix.length();

            for (int i=itemLength-1; i>=0; i--) {
                if (isOperator(prefix.charAt(i))) {
                    // 만약 현재 인덱스의 char가 연산자일 경우
                    // 앞의 두 인자를 뽑아낸 다음
                    String it1 = stack.peek();
                    stack.pop();
                    String it2 = stack.peek();
                    stack.pop();

                    // 연산자를 인자들의 뒤로 이동한다.
                    String temp = it1 + it2 + prefix.charAt(i);
                    stack.push(temp); // 그리고 다시 stack에 push한다.
                } else {
                    // 현재 인덱스의 char가 연산자가 아닐 경우
                    // 현재 인덱스의 숫자를 stack에 push한다.
                    stack.push(prefix.charAt(i)+"");
                }
            }
//            System.out.println("result : "+stack.peek());
            result.add(stack.peek());
        }

        return result;
    }

    public void getResult() {
        List<String> prefixes = new ArrayList<String>();
        prefixes.add("*34");
        prefixes.add("+1*23");
        prefixes.add("+12");
        prefixes.add("+1**23/14");
        List<String> result = prefixToPostfix(prefixes);
//        for (String item : result) {
//            System.out.println(item);
//        }
    }
}
