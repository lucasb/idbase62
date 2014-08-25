package com.github.openconde.idbase62;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IdentificationTest {
	
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
