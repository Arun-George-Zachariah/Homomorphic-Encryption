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

    public static BigInteger floorMod(BigInteger x, BigInteger y) {
        BigInteger r = x.subtract(floorDiv(x, y).multiply(y));
        return r;
    }

    public static BigInteger floorDiv(BigInteger x, BigInteger y) {
        BigInteger r = x.divide(y);
        if ((x.xor(y)).compareTo(BigInteger.ZERO) < 0 && (r.multiply(y) != x)) {
            r.subtract(BigInteger.ONE);
        }
        return r;
    }

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        while(b.compareTo(BigInteger.ZERO) > 0) {
            BigInteger temp = b;
            b = a.mod(b);
            a = temp;
        }
        return a;
    }

    public static BigInteger lcm(BigInteger a, BigInteger b) {
        BigInteger lcm = (a.multiply(b)).divide(gcd(a,b));
        return lcm;
    }

    public static BigInteger[] extended_euclidean_algorithm(BigInteger a, BigInteger b) {
        System.out.println("a :: "  + a + " :: b :: " + b);
        BigInteger s = BigInteger.ZERO;
        BigInteger old_s = BigInteger.ONE;
        BigInteger t = BigInteger.ONE;
        BigInteger old_t = BigInteger.ZERO;
        BigInteger r = b;
        BigInteger old_r = a;

        while(!r.equals(BigInteger.ZERO)) {
            BigInteger quotient = old_r.divide(r);
            BigInteger temp1 = old_r;
            old_r = r;
            r = temp1.subtract(quotient.multiply(r));

            BigInteger temp2 = old_s;
            old_s = s;
            s = temp2.subtract(quotient.multiply(s));

            BigInteger temp3 = old_t;
            old_t = t;
            t =  temp3.subtract(quotient.multiply(t));
        }
        BigInteger[] retArr = {old_r, old_s, old_t};
        return retArr;
    }

    public static BigInteger inverse_of(BigInteger n, BigInteger p) {
        BigInteger[] distArr = extended_euclidean_algorithm(n, p);

        BigInteger gcd = distArr[0];
        BigInteger x = distArr[1];
        BigInteger y = distArr[2];

        if (!gcd.equals(BigInteger.ONE)) {
            System.out.println("Cannot be solved!!!");
            return BigInteger.ZERO.subtract(BigInteger.ONE);
        } else {
            return floorMod(x, p);
        }
    }

    public static BigInteger pow(BigInteger a, BigInteger b, BigInteger c) {
        return a.modPow(b,c);
    }
}
