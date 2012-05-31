package file;

public class FileExtension extends RenameFile{
	
	public FileExtension(String source){
		super(source);
	}
	
	public String getExtension(){
		String source = this.getFile().getName();
		int mid = source.lastIndexOf(".");
		source = source.substring(mid, source.length());
		
		return source ;
	}
	
	
	
	public static void main(String[] args){
		String source = "D:/buku";
		FileExtension ext = new FileExtension(source);
		System.out.println(ext.getFile());
	}

}
