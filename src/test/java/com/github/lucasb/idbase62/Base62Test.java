package com.github.lucasb.idbase62;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.lucasb.idbase62.Base62;

public class Base62Test {

    @Test
    public void testFromDecimal() throws Exception {
        long n = 0;
        String str = "6JaY2";
        char[] chars = str.toCharArray();
        n += new String(Base62.ELEMENTS).indexOf(chars[0]) * (int) Math.pow(62, 4);
        n += new String(Base62.ELEMENTS).indexOf(chars[1]) * (int) Math.pow(62, 3);
        n += new String(Base62.ELEMENTS).indexOf(chars[2]) * (int) Math.pow(62, 2);
        n += new String(Base62.ELEMENTS).indexOf(chars[3]) * (int) Math.pow(62, 1);
        n += new String(Base62.ELEMENTS).indexOf(chars[4]) * (int) Math.pow(62, 0);
        assertEquals(str, Base62.fromDecimal(n));
    }
    
    @Test
    public void testFromDecimalZero() throws Exception {
        long n = 0;
        String str = String.valueOf(Base62.ELEMENTS[(int) n]);
        assertEquals(str, Base62.fromDecimal(n));
    }

    @Test
    public void testToDecimal() throws Exception {
        assertEquals(125L, Base62.toDecimal("cb"));
    }

    @Test
    public void testIsValid() throws Exception {
        assertEquals(true, Base62.isValid("54ff"));
    }

    @Test
    public void testIsValidEmptyValue() throws Exception {
        assertEquals(false, Base62.isValid(""));
    }

    @Test
    public void testIsValidNotValidValue() throws Exception {
        assertEquals(false, Base62.isValid("54#ff"));
    }

    @Test
    public void testPlus() throws Exception {
        assertEquals("fdtA", Base62.plus("e7Pr", "54t"));
    }

    @Test
    public void testMinus() throws Exception {
        assertEquals("e7Pr", Base62.minus("fdtA", "54t"));
    }
    
    @Test
    public void testInstanceClass() throws Exception {
        Base62 base62 = new Base62();
        assertEquals(base62.getClass(), Base62.class);
    }

}
