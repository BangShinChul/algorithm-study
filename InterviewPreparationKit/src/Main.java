import InterviewPreparationKit.CountingValleys;
import InterviewPreparationKit.JumpingOnTheClouds;
import InterviewPreparationKit.SockMerchant;
import SixShopCodingTest.Test1;
import SixShopCodingTest.Test2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // SockMerchant
//        int[] ar = {
//                10, 20, 20, 10, 10, 30, 50, 10, 20,
//                10, 20, 20, 10, 10, 30, 50, 10, 20,
//                1, 1, 3, 1, 2, 1, 3, 3, 3, 3, 4, 5,
//                7, 5, 4, 7, 3, 5, 3, 4, 6, 7, 8, 5,
//                14, 5, 45, 6, 4,3, 6, 36,37, 7,48, 68,
//        };
//
//        int n = ar.length;
//
//        SockMerchant socks = new SockMerchant();
//        System.out.println(socks.getResult(n, ar));


        // CountingValley
//        int n = 8;
//        String s = "UUDDDUDDUUUDDUDDUDUUDUUDUDUDDDUUUDDDDUUDUDUUUDDUUDUDUDDDUUUD";
//        CountingValleys c = new CountingValleys();
//        System.out.println(c.getResult(n, s));


        // JumpingOnTheClouds
//        int[] c = {0,0,0,0,1,0};
//        int[] c = {0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0};
//        JumpingOnTheClouds jumping = new JumpingOnTheClouds();
//        System.out.println("result: " + jumping.getResult(c));

        // SixShopCodingTest
//        Test1 one = new Test1();
//        List<String> data = new ArrayList<>();

//        data.add("we promptly judged antique ivory buckles for the next prize");
//        data.add("we promptly judged antique ivory buckles for the prizes");
//        data.add("the quick brown fox jumps over the lazy dog");
//        data.add("the quick brown fox jump over the lazy dog");

//        data.add("cfchcfcvpalpqxenhbytcwazpxtthjumliiobcznbefnofyjfsrwfecxcbmoafes tnulqkvx");
//        data.add("oxhctvhybtikkgeptqulzukfmmavacshugpouxoliggcomykdnfayayqutgwivwldrkp");
//        data.add("gpecfrak zzaxrigltstcrdyhelhz rasrzibduaq  cnpuommogatqem");
//        data.add("hbybsegucruhxkebrvmrmwhweirx mbkluwhfapjtga liiylfphmzkq");

//        one.isPangram(data);
//        System.out.println(one.isPangram(data));
//        one.test111(data);

        Test2 two = new Test2();
//        String[] data = {"{}()[]","{[}]}"};
        String[] data = {"{[()]}","{[(])}","{{[[(())]]}}"};
        String[] result = two.braces(data);
        for (String item : result) {
            System.out.println(item);
        }
        two.test();
    }
}
