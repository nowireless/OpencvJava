package org.nowireless.opencv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OpencvJava {
	
	private static boolean LOADED = false;

	public static boolean load() {
		if(!LOADED) {
			String os = System.getProperty("os.arch");
			InputStream in = OpencvJava.class.getResourceAsStream("/org/opencv/native/"+os+"/opencv_java310.dll");
			
			try {
				File jniLib = File.createTempFile("opencv_java310" + os, ".dll");
				System.out.println(jniLib);
				OutputStream out = new FileOutputStream(jniLib);
				jniLib.deleteOnExit();
				System.out.println(in);
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
				LOADED = true;
			} catch (IOException e) {
				e.printStackTrace();
				LOADED = false;
			}
		}
		return LOADED;
	}
}
