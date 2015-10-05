package com.github.lucasb.idbase62;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IdentificationTest {
    
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    

    @Test
    public void testIdentification() throws Exception {
        Identification id = new Identification();
        assertEquals("a", id.toString());
    }

    @Test
    public void testIdentificationValue() throws Exception {
        String value = "wQ7r";
        Identification id = new Identification(value);
        assertEquals(value, id.toString());
    }
    
    @Test(expected = RuntimeException.class)
    public void testIdentificationException() throws Exception {
        String value = "z_89";
        new Identification(value);
        expectedEx.expectMessage("Cannot instance class because the value is not valid.");
    }

    @Test
    public void testBefore() throws Exception {
        String value = "c";
        Identification id = new Identification(value);
        assertEquals("b", id.before().toString());
    }

    @Test
    public void testNext() throws Exception {
        String value = "cc";
        Identification id = new Identification(value);
        assertEquals("cd", id.next().toString());
    }

    @Test
    public void testEquals() throws Exception {
        String value = "kK2l";
        Identification id = new Identification(value);
        Identification id2 = new Identification(value);
        assertEquals(true, id.equals(id2));
    }

    @Test
    public void testEqualsFalse() throws Exception {
        String value = "kK2l";
        String value2 = "2222";
        Identification id = new Identification(value);
        Identification id2 = new Identification(value2);
        assertEquals(false, id.equals(id2));
    }

}
