package SixShopCodingTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
알파벳의 모든글자를 사용해서 만든 단어인지 확인해서 트루 펄스 출력

ascii

System.out.println((int)


        //65 ~ 90 A-Z
        //97 ~ 122 a-z

 * */
public class Test1 {

    public static String isPangram (List<String> strings) {
        StringBuilder result = new StringBuilder();
        List<String> alphabetList = new ArrayList<>();

        for (int i=97; i<123; i++) {
            char alphabet = (char) i;
//            System.out.println(alphabet);
            alphabetList.add(Character.toString(alphabet));
        }

        int strLength = strings.size();
        for (int j=0; j<strLength; j++) {
            boolean checkFlag = true;
            String item = strings.get(j).trim();
            for (String key : alphabetList) {
                if (!item.contains(key)) {
                    result.append("0");
                    checkFlag = false;
                    break;
                } else {
                    continue;
                }
            }
            if(checkFlag) {
                result.append("1");
            }
        }

        return result.toString();
    }

    public void test111 ()
    {
        for (int i=97; i<123; i++) {
            char alphabet = (char) i;
            System.out.println(alphabet);
//            alphabetList.put((char)97, false);
        }
    }
}
