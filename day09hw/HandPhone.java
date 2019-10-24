package day09hw;

public class HandPhone {
	
	private String productName;
	private String phoneNumber;
	private int productOld;
	private int productPrice;
	
	HandPhone(){
		productName = "πÃ±‚¿‘";
		phoneNumber = "010-xxxx-xxxx";
		productOld = 100;
		productPrice = 99999999;
	}
	
	HandPhone(String productName, String phoneNumber, 
						int productOld, int productPrice){
		this();
		this.productName = productName;
		this.phoneNumber = phoneNumber;
		this.productOld = productOld;
		this.productPrice = productPrice;
	}
	
	
	public HandPhone(String productName, String phoneNumber) {
		this();
		this.productName = productName;
		this.phoneNumber = phoneNumber;
	}

	public void phoneCall() {
		System.out.println("call");
	}
	public void phoneReceive() {
		System.out.println("receive");
	}
	
	
	//String productName, String phoneNumber,int productOld, int productPrice

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setProductOld(int productOld) {
		this.productOld = productOld;
	}
	
	public int getProductPrice() {
		return this.productPrice;
	}
	
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	

}
