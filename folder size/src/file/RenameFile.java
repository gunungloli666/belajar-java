package file;

import java.io.File;

public  class RenameFile{

    File file;
    protected  File filelist[];

	public RenameFile(String folder) {
		try {
			this.file  = new File(folder);
			filelist = file.listFiles();
		} catch (Exception e) {
			System.out.println("salah memasukkan nama folder.. !!");
		}
	}
	
	
	
	public  File getFile(){
		return this.file;
	}
	
	

	public void rename(String myString) {

		for (int i = 0; i < filelist.length; i++) {
			File file = filelist[i];
			
			if(!file.isDirectory() ){
				this.renameFile(file, myString);
			}else{
				String path = file.getAbsolutePath().replace("\\", "/");
				new RenameFile(path).rename(myString);
			}	
		}
	}
	

	protected String  getRenameString(File f , String myString){
		
		String b =  f.getAbsolutePath();
		int c  = b.lastIndexOf("\\");
		String temp = b.substring(0, c);
		String temp1 = b.substring(c+1, b.length());
		temp = temp.replace("\\", "/").concat("/");
		String dest = temp.concat(myString).concat(temp1);
		
		return dest;
	}
	

	
	
	protected void renameFile(File f, String myString){
		
		String b =  f.getAbsolutePath();
		int c  = b.lastIndexOf("\\");
		String temp = b.substring(0, c);
		String temp1 = b.substring(c+1, b.length());
		temp = temp.replace("\\", "/").concat("/");
		String dest = temp.concat(myString).concat(temp1);
		
		boolean sukses = f.renameTo(new File(dest));
		
		if(!sukses){
			System.out.println("gagal:  "+ f.getAbsolutePath());
		}
	}
	
	

	public static void main(String args[]) {

		String source= "D:/mamat";
		RenameFile rename = new RenameFile(source);
		rename.rename("equal__");
		System.out.println("\n FINISH");

	}
}
