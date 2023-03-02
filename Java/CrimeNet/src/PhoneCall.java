
public class PhoneCall extends Communication {

	private int duration;
	private Communication[] comm = new Communication[14];
	
	public PhoneCall(String num1, String num2, int day, int month, int year, int duration) {
		
		super(num1,  num2,  day,  month,year);
		this.duration = duration;
	}
	
//Overriding//
	public void printInfo() {
		System.out.println("This phone call has the following info");
		System.out.println("Between " + super.getNum1() + " --- " + super.getNum2() );
		System.out.println("on " + super.getYear() +"/" + super.getMonth() +"/" + super.getDay());
		System.out.println("Duration: " + duration);
		
	}

	public int getDuration() {
		
		return duration;
	}
	
	

	
	

}
