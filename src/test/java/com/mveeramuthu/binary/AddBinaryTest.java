package com.mveeramuthu.binary;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AddBinaryTest { 
    @Test
    public void test1() {
        assertEquals("11010", AddBinary.addBinary("1001", "10001"));
    }
}
