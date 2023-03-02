
public class SMS extends Communication {
	
	
	private String messege;
	
	public SMS(String num1, String num2, int day, int month, int year, String messege) {
		
		super( num1, num2, day,  month,  year);
		
		this.messege = messege;
	}
	
//Overriding//
	public void printInfo() {
		System.out.println("This messege has the following info");
		System.out.println("Between " + super.getNum1() + " --- " + super.getNum2()+ " on " + super.getYear() +"/" + super.getMonth() +"/" + super.getDay());
		System.out.println("Text: " + messege);
		
	}
	
	public String getMessege() {
		return messege;
	}
	
	public String getContentofMessege() {
		return messege;
	}
	

}
