package edu.umkc.Hash;

import edu.umkc.Constants.Constants;
import edu.umkc.Util.CommonUtil;

public class HomomorphicHash {

    private static final CommonUtil util = CommonUtil.getInstance();
    private static final int n = Constants.P * Constants.Q;

    public static void main(String[] args) {
        addHash(10, 2);
    }

    public static int getHash(int m) {
        int k1 = util.pow(Constants.G, m, n*n);
        int k2 = util.pow(Constants.R, n, n*n);

        int hash = (int) util.floorMod((long)k1*k2,(long)n*n);
        System.out.println("Hash Generated :: " + hash);

        return hash;
    }

    public static int addHash(int mes1, int mes2) {
        int n = Constants.P * Constants.Q;
        int hash1 =  getHash(mes1);
        int hash2 =  getHash(mes2);
        int ciphertotal = (int) util.floorMod((long) hash1 * hash2 , (long) n*n);
        System.out.println("Total :: " + ciphertotal);
        return ciphertotal;
    }

    public static int getMessage(int cipher) {

        int gLambda = util.lcm(Constants.P - 1,Constants.Q - 1);
        int l = (util.pow(Constants.G, gLambda, n*n)-1)/n;
        int gMu = util.inverse_of(l, n);

        l = (util.pow(cipher, gLambda, n*n)-1)/n;

        int mes= (l * gMu) % n;
        System.out.println("Message :: " + mes);
        return mes;
    }

}
