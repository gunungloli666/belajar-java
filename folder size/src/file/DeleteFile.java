package file;

import java.io.*;

public class DeleteFile extends RenameFile {

	public DeleteFile(String source) {
		super(source);
	}

	public void delete() {

		for (int i = 0; i < filelist.length; i++) {
			
			File f = filelist[i];
			String sub = f.getAbsolutePath();
			int c = sub.lastIndexOf(".");
			sub = sub.substring(c+1, sub.length());
			
			if(!(sub.equalsIgnoreCase("zip"))){
				boolean sukses = f.delete();
				
				if(!sukses){
					System.out.println("gagal: "+f.getAbsolutePath());
				}
			}
		}
	}
	
	

	public static void main(String[] args){
		
		String a = "D:/buku bagus/Philosophy En";
		
		DeleteFile del = new DeleteFile(a);
		del.delete();
		
	}
}