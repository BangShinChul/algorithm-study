package SixShopCodingTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*

{}()[] : true
{({])] : false

특징 :
- (,{,[ 가 나오고 나서 ),},] 를 비교해봤을때 왼쪽과 같은종류가 아니라면 틀림.
즉 무조건왼쪽이 먼저나와야하고 오른쪽이 나오기 시작했을 때 왼쪽의 순서와 오른쪽의 순서가
동일해야함.


 * */
public class Test2 {

    public String[] braces(String[] values) {
        int valuesLength = values.length;
        String[] result = new String[valuesLength];

        valuesCheckLoop:
        for (int i=0; i<valuesLength; i++) {
            char[] items = values[i].toCharArray();
            Stack stack = new Stack();

            itemCheckLoop:
            for (char item : items) {
                if (item == ')') {
                    if (!stack.empty()){
                        if ((Character)stack.peek() != '(') {
                            result[i] = "NO";
                            break itemCheckLoop;
                        } else {
                            stack.pop();
                        }
                    }
                } else if (item == '}') {
                    if (!stack.empty()){
                        if ((Character)stack.peek() != '{') {
                            result[i] = "NO";
                            break itemCheckLoop;
                        } else {
                            stack.pop();
                        }
                    }
                } else if (item == ']') {
                    if (!stack.empty()){
                        if ((Character)stack.peek() != '[') {
                            result[i] = "NO";
                            break itemCheckLoop;
                        } else {
                            stack.pop();
                        }
                    }
                } else {
                    stack.push(item);
                }
            }

            if(result[i] == null && stack.empty()) {
                result[i] = "YES";
            }
        }
        return result;
    }

    public void test () {
        Stack stack = new Stack();
        System.out.println(stack.empty());
    }
}
