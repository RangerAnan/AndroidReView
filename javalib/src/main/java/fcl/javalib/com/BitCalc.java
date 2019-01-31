package fcl.javalib.com;

/**
 * Created by fcl on 19.1.29
 * desc: 位计算
 */

public class BitCalc {


    /**
     * 6<<2 --> 00000111 左移两位 --> 00011000 --> 8+16=24
     */

    public static void calc1() {
        int a = 2;
        int result = a++;
//        int result1 = a++ + 4;   //6
//        int result2 = a++ + 4 << 2;

        System.out.print("BitCalc--i:" + result);

    }
}
