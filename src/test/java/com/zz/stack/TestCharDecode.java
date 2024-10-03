package com.zz.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCharDecode {

    @Test
    public void testCharDecode() {
        CharDecode cd = new CharDecode();
        String ret = cd.decodeString("2[ab1[bc]]");

        Assertions.assertEquals("abbcabbc", ret);
    }
}
