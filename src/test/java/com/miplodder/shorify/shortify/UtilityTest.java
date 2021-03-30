package com.miplodder.shorify.shortify;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class UtilityTest {

    @Test
    public void testEncoding() {
        assertEquals(Utility.encoding(5), "e");
        assertEquals(Utility.encoding(21), "u");
        assertEquals(Utility.encoding(26), "z");
        assertEquals(Utility.encoding(29), "zc");
        assertEquals(Utility.encoding(55), "zzc");
        assertEquals(Utility.encoding(112), "zzzzh");
    }

}
