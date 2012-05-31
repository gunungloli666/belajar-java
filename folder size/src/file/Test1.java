package file;

import java.io.File;

public class Test1 {
	
	public static void main(String[] args){
	
		//String mm = "mari/berdua/makan/bersmaa";
		String a = "D:/mamat";
		String myString = "fajar___";
		
		File ff[] = new File(a).listFiles();
		
		for(int i=0; i< ff.length ;i++){
			File f = ff[i];
			
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
	}

}
