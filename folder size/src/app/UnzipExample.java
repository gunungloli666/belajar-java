package app;

import java.io.*;
import java.util.zip.*;

public class UnzipExample {
	
	public static void main(String a[]) {
		try {
			BufferedOutputStream out = null;
			
			ZipInputStream in = new ZipInputStream(new BufferedInputStream(
					new FileInputStream(a[0])));
			
			ZipEntry entry;
			
			while ((entry = in.getNextEntry()) != null) {
				int count;
				byte data[] = new byte[1000];
				out = new BufferedOutputStream(new FileOutputStream("out.txt"),
						1000);
				
				while ((count = in.read(data, 0, 1000)) != -1) {
					out.write(data, 0, count);
				}
				
				out.flush();
				out.close();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
}