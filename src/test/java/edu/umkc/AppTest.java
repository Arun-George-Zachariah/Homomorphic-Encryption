package edu.umkc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.umkc.Hash.HomomorphicHash;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        BigInteger mes1 = BigInteger.valueOf(20);
        BigInteger mes2 = BigInteger.valueOf(4);
        BigInteger expected = BigInteger.valueOf(24);
        assertEquals(expected, HomomorphicHash.getMessage(HomomorphicHash.addHash(mes1, mes2)));
    }
}
