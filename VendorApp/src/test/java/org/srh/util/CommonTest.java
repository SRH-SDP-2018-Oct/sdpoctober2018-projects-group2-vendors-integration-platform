package org.srh.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommonTest {

	@Test
	public void testNullOrEmpty() {
		assertTrue(Common.nullOrEmpty(null));
		assertTrue(Common.nullOrEmpty(""));
	}

	@Test
	public void testNullOrEmptyTrim() {
		assertTrue(Common.nullOrEmptyTrim(null));
		assertTrue(Common.nullOrEmptyTrim(""));
		assertTrue(Common.nullOrEmptyTrim(" "));
	}

}
