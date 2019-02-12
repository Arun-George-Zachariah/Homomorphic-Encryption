package edu.umkc.Util;

import java.math.BigInteger;

public class CommonUtil {

    private static CommonUtil instance = null;
    private void CommonUtil() {

    }

    public static CommonUtil getInstance() {
        if(instance == null) {
            instance = new CommonUtil();
        }
        return instance;
    }

    public static long floorMod(long x, long y) {
        long r = x - floorDiv(x, y) * y;
        return r;
    }

    public static long floorDiv(long x, long y) {
        long r = x / y;
        if ((x ^ y) < 0 && (r * y != x)) {
            r--;
        }
        return r;
    }

    public static int gcd(int a, int b) {
        while(b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        int lcm = (a*b)/gcd(a,b);
        return lcm;
    }

    public static int[] extended_euclidean_algorithm(int a, int b) {
        System.out.println("a :: "  + a + " :: b :: " + b);
        int s =0;
        int old_s = 1;
        int t = 1;
        int old_t = 0;
        int r = b;
        int old_r = a;

        while(r != 0) {
            int quotient = old_r/r;
            int temp1 = old_r;
            old_r = r;
            r = temp1 - quotient * r;

            int temp2 = old_s;
            old_s = s;
            s = temp2 - quotient * s;

            int temp3 = old_t;
            old_t = t;
            t =  temp3 - quotient * t;
        }
        int[] retArr = {old_r, old_s, old_t};
        return retArr;
    }

    public static int inverse_of(int n, int p) {
        int[] distArr = extended_euclidean_algorithm(n, p);

        int gcd = distArr[0];
        int x = distArr[1];
        int y = distArr[2];

        if (gcd != 1) {
            System.out.println("Cannot be solved!!!");
            return -1;
        } else {
            return (int) floorMod((long)x,(long)p);
        }
    }

    public static int pow(int a, int b, int c) {
        return BigInteger.valueOf(a).pow(b).mod(BigInteger.valueOf(c)).intValue();
    }
}
