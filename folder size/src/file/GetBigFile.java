package file;

import java.io.File;

public class GetBigFile extends  RenameFile{
	
	double maxSize;
	
	public GetBigFile(String source, double maxsize){
		super(source);
		this.maxSize = maxsize;
	}
	
	public void rename(String m){
		
		for(int i=0; i< filelist.length; i++){
			
			File f = filelist[i];
			if(!f.isDirectory()){
				 double  size = (double) f.length()/(1024*1024); //size in mb 
				 
				 if(size >= maxSize){
					 renameFile(f, m);
				 }
			}else{
				String path = f.getAbsolutePath().replace("\\", "/");
				new GetBigFile(path, maxSize).rename(m);
			} 
		}

	}
	
	public static void main(String[] args){
		
		String s = "D:/mamat";
		GetBigFile big = new GetBigFile(s, 5);
		big.rename("lebih besar dari 5 mb___");
		
		System.out.println("sukses...");
		
 	}

}
