package app;

import java.io.*;
import file.RenameFile;
import java.util.*;
import java.util.zip.*;

public class MyUnZip extends RenameFile {

	String dest;
	static final int BUFFER = 2048;
	
	public MyUnZip(String source, String dest) {
		
		super(source);
		this.dest = dest;
		
	}



	public void extract() {
		
		for (int i = 0; i < filelist.length; i++) {

			File f = filelist[i];
			String a = super.getRenameString(f, "");
			String b = super.getRenameString(f.getParentFile(), "").concat(
					dest);

			if (!f.isDirectory()) {

				try {

					BufferedOutputStream dest = null;
					BufferedInputStream is = null;

					ZipEntry entry;
					ZipFile zipfile = new ZipFile(a);
					Enumeration e = zipfile.entries();

					while (e.hasMoreElements()) {
						
						entry = (ZipEntry) e.nextElement();
						System.out.println("Extract file: " + entry);
						is = new BufferedInputStream(
								zipfile.getInputStream(entry));
						int count;
						byte data[] = new byte[BUFFER];

						String x = b.concat(entry.getName());

						FileOutputStream fos = new FileOutputStream(x);
						dest = new BufferedOutputStream(fos, BUFFER);
						while ((count = is.read(data, 0, BUFFER)) != -1) {
							dest.write(data, 0, count);
						}
						dest.flush();
						dest.close();
						is.close();

					}
					
				} catch (Exception e) {
					System.out.println("gagal: " + f.getAbsolutePath());
					e.printStackTrace();
				}

			}

		}
	}

	public static void main(String[] args) {
		String source = "D:/buku bagus/filsafat_1";
		MyUnZip unzip = new MyUnZip(source, "/hasil/"); //EGP... yang penting jalan
		unzip.extract();
	}

}