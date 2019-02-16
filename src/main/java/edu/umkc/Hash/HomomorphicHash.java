package edu.umkc.Hash;

import edu.umkc.Constants.Constants;
import edu.umkc.Util.CommonUtil;

import java.math.BigInteger;

public class HomomorphicHash {

    private static final CommonUtil util = CommonUtil.getInstance();
    private static final BigInteger n = Constants.P.multiply(Constants.Q);

    public static void main(String[] args) {
        BigInteger mes1 = new BigInteger("10");
        BigInteger mes2 = new BigInteger("2");
        getMessage(addHash(mes1, mes2));
    }

    public static BigInteger getHash(BigInteger m) {
        BigInteger k1 = util.pow(Constants.G, m, n.multiply(n));
        BigInteger k2 = util.pow(Constants.R, n, n.multiply(n));

        BigInteger hash = util.floorMod(k1.multiply(k2), n.multiply(n));
        System.out.println("Hash Generated :: " + hash);

        return hash;
    }

    public static BigInteger addHash(BigInteger mes1, BigInteger mes2) {
        BigInteger hash1 =  getHash(mes1);
        BigInteger hash2 =  getHash(mes2);
        BigInteger ciphertotal = util.floorMod(hash1.multiply(hash2) , n.multiply(n));
        System.out.println("Total :: " + ciphertotal);
        return ciphertotal;
    }

    public static BigInteger getMessage(BigInteger cipher) {
        BigInteger gLambda = util.lcm(Constants.P.subtract(BigInteger.ONE),Constants.Q.subtract(BigInteger.ONE));
        BigInteger l = (util.pow(Constants.G, gLambda, n.multiply(n)).subtract(BigInteger.ONE)).divide(n);
        BigInteger gMu = util.inverse_of(l, n);

        l = (util.pow(cipher, gLambda, n.multiply(n)).subtract(BigInteger.ONE)).divide(n);

        BigInteger mes= (l.multiply(gMu)).mod(n);
        System.out.println("Message :: " + mes);
        return mes;
    }

}
