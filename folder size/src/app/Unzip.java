package app;

import file.*;

import java.io.*;
import java.util.*;
import java.util.zip.*;

public class Unzip {

	public static final void copyInputStream(InputStream in, OutputStream out)
			throws IOException {
		byte[] buffer = new byte[1024];
		int len;
		while ((len = in.read(buffer)) >= 0)
			out.write(buffer, 0, len);

		in.close();
		out.close();
	}

	public static final void main(String[] args) {
		Enumeration  entries;
		ZipFile zipFile;
		String data = "D:/mamat";
		try {
			zipFile = new ZipFile(data);
			entries = zipFile.entries();
			while (entries.hasMoreElements()) {

				ZipEntry entry = (ZipEntry) entries.nextElement();
				if (entry.isDirectory()) {
					// Assume directories are stored parents first then
					// children.
					System.err.println("Extracting directory: "
							+ entry.getName());
					// This is not robust, just for demonstration purposes.
					(new File(entry.getName())).mkdir();
					continue;
				}
				System.err.println("Extracting file: " + entry.getName());

				copyInputStream(
						zipFile.getInputStream(entry),
						new BufferedOutputStream(new FileOutputStream(entry
								.getName())));
			}

			zipFile.close();

		} catch (IOException ioe) {
			System.err.println("Unhandled exception:");
			ioe.printStackTrace();
			return;
		}
	}
}