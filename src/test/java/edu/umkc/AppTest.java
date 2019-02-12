package edu.umkc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.umkc.Hash.HomomorphicHash;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        assertEquals(24, HomomorphicHash.getMessage(HomomorphicHash.addHash(20,4)));
    }
}
