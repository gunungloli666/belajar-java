package test;

public class B extends A {
	
	int ID;
	
	public B(String nama , int ID){
		super(nama);
		this.ID = ID;
	}
	
	public void print(){
		System.out.println(nama+ "  "+ ID);
	}
	

}
