package CremaCodingTest;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/*
일 월 년 형식의 날짜 문자열을 제공합니다.

Day의 구성은 다음과 같습니다.
{"1st", "2nd", "3rd", "4th", "5th", "6th"...... "29th","30th","31st"}.

Month의 구성은 다음과 같습니다.
{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}

Year은 1900년 ~ 2100년까지 있습니다.

날짜 문자열을 YYYY-MM-DD 형식으로 변환하십시오. 여기서,

YYYY는 4 자리 연도를 나타냅니다.
MM은 2 자리 월을 나타냅니다.
DD는 2 자리 날짜를 나타냅니다.

예)
1st Mar 1984 -> 1984-03-01
2nd Feb 2013 -> 2013-02-02
4th Apr 1900 -> 1900-04-04


아래 편집기에서 함수 형식 변환을 완료하십시오.
이 함수는 변환 된 날짜 문자열 배열을 표시된 순서대로 반환해야합니다.

stdin으로부터의 입력은 다음과 같이 처리되고 함수로 전달됩니다.

첫 번째 줄에는 배열 날짜의 크기 인 정수 n이 포함됩니다.
다음 n 개의 줄 각각에는 0 <= i <= n 인 문자열 [dates] [i]가 있습니다.

일, 월, 년의 값은 위에 지정된 값 범위로 제한됩니다.
주어진 날짜는 유효하기 때문에 오류 처리가 필요하지 않습니다.

- 샘플 입력 0
10
20th Oct 2052
6th Jun 1933
26th May 1960
20th Sep 1958
16th Mar 2068
25th May 1912
16th Dec 2018
26th Dec 2061
4th Nov 2030
28th Jul 1963

- 샘플 출력 0
2052-10-20
1933-06-06
1960-05-26
1958-09-20
2068-03-16
1912-05-25
2018-12-16
2061-12-26
2030-11-04
1963-07-28

- 샘플 해설 0
다음 n = 10 개의 날짜를 변환합니다.
20th Oct 2052 → 2052-10-20
 6th Jun 1933 → 1933-06-06
26th May 1960 → 1960-05-26
20th Sep 1958 → 1958-09-20
16th Mar 2068 → 2068-03-16
25th May 1912 → 1912-05-25
16th Dec 2018 → 2018-12-16
26th Dec 2061 → 2061-12-26
 4th Nov 2030 → 2030-11-04
28th Jul 1963 → 1963-07-28


* */
public class ReformattingDates {

    public static List<String> reformatDate(List<String> dates) {
        // Write your code here

        List<String> result = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        for (String item : dates) {
            int dateLength = item.length();
            String date = dateLength > 12 ?
                    item.substring(0, 2) + item.substring(4,dateLength) : item.substring(0, 1) + item.substring(3,dateLength) ;
            System.out.println("item : "+item);
            System.out.println("date : "+date);
            Date d = new Date(date);
            System.out.println("before : " + d);
            System.out.println("after : " + format.format(d)+"\n");
            result.add(format.format(d));
        }

        return result;
    }

    public static List<String> reformatDate2(List<String> dates) {
        // Write your code here

        List<String> result = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        for (String item : dates) {
//            String date = item.replace("st", "");
//            date = date.replace("nd", "");
//            date = date.replace("rd", "");
//            date = date.replace("th", "");

            String date = item.replace("st","")
                    .replace("nd", "")
                    .replace("rd", "")
                    .replace("th", "");
            System.out.println("date : "+date);
            Date d = new Date(date);
            System.out.println("before : "+d);
            System.out.println("after : "+format.format(d)+"\n");
            result.add(format.format(d));
        }

        return result;
    }

    public static List<String> reformatDate3(List<String> dates) {
        // Write your code here

        List<String> result = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        Iterator<String> iterator = dates.iterator();
        while (iterator.hasNext()) {

            String date = iterator.next();
            int dateLength = date.length();
            String newDate = dateLength > 12 ?
                    date.substring(0, 2) + date.substring(4,dateLength) : date.substring(0, 1) + date.substring(3,dateLength) ;

            System.out.println("iterator.next() : "+date);
            System.out.println("newDate : "+newDate);

            Date d = new Date(newDate);

            System.out.println("before : " + d);
            System.out.println("after : " + format.format(d)+"\n");

            result.add(format.format(d));

        }

        return result;
    }
    public void test() {
        Date d = new Date("20 Oct 2052");
//        SimpleDateFormat format = new SimpleDateFormat("dd MMM YYYY", Locale.UK);
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd", Locale.UK);
        String s = d.toString();
        System.out.println(format.format(d));
    }

    public void getResult() {
        /*
        10
        20th Sep 2041
        6th Dec 1918
        22nd May 1925
        6th Nov 1925
        19th Oct 2051
        6th Nov 2060
        18th Apr 2032
        6th Jul 2044
        1st Sep 1991
        19th Jan 2029
        3rd Jan 2099
        2nd Aug 2054
        15th Jul 2047
        28th Mar 1915
        20th Nov 1946
        14th Sep 1995
        27th Oct 1977
        14th Jan 2025
        5th Nov 1944
        23rd Jun 2072
        * */

        String ss = "20th Sep 2041," +
                "6th Dec 1918," +
                "22nd May 1925," +
                "6th Nov 1925," +
                "19th Oct 2051," +
                "6th Nov 2060," +
                "18th Apr 2032," +
                "6th Jul 2044," +
                "1st Sep 1991," +
                "19th Jan 2029," +
                "3rd Jan 2099," +
                "2nd Aug 2054," +
                "15th Jul 2047," +
                "28th Mar 1915," +
                "20th Nov 1946," +
                "14th Sep 1995," +
                "27th Oct 1977," +
                "14th Jan 2025," +
                "5th Nov 1944," +
                "23rd Jun 2072";

//        String[] arr = ss.split(",");
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < 100000) {
            list.add("23rd Jun 2072");
            i++;
        }
//        for(String item : arr) {
//            list.add(item);
//        }

        reformatDate3(list);
    }
}
