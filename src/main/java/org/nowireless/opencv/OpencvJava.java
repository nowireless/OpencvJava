package org.nowireless.opencv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OpencvJava {

	public static void load() {
		InputStream in = OpencvJava.class.getResourceAsStream("/org/opencv/native/win64/opencv_java310.dll");
		
		try {
			File jniLib = File.createTempFile("opnecv_java310", ".dll");
			OutputStream out = new FileOutputStream(jniLib);
			jniLib.deleteOnExit();

			byte[] buffer = new byte[1024];
			int readBytes;
			try {
				while ((readBytes = in.read(buffer)) != -1) {
					out.write(buffer, 0, readBytes);
				}
			} finally {
				out.close();
				in.close();
			}

			System.load(jniLib.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
