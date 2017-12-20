package com.stone.stream.file;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDescriptorTest {

	public static void main(String[] args) {
		try {
			FileInputStream in = new FileInputStream(FileDescriptor.in);
			System.out.println(in.read());
		    FileOutputStream out = new FileOutputStream(FileDescriptor.out);
		    FileOutputStream error = new FileOutputStream(FileDescriptor.err);
		    out.write('A');
		    error.write('B');
		    out.close();
		    error.close();
		} catch (IOException e) {
		}
	}
}
