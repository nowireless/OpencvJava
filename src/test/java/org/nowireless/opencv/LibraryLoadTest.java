package org.nowireless.opencv;

import static org.junit.Assert.*;

import org.junit.Test;
import org.opencv.core.Mat;

public class LibraryLoadTest {

	@Test
	public void test() {
		OpencvJava.load();
		
		Mat mat = new Mat();
		assertTrue(mat.empty());
		
	}

}
