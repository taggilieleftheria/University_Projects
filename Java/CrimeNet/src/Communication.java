
public abstract class Communication  {
	
	private String Num1;
	private String Num2;
	private int day;
	private int month;
	private int year;

	
	public Communication(String num1, String num2, int day, int month, int year) {
		
		Num1 = num1;
		Num2 = num2;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public void printInfo() {
		System.out.println("This phone call has the following info");
		System.out.println("Between " + Num1 + " --- " + Num2 + " on " + year +"/" + month +"/" + day);
		
		
	}

	public String getNum1() {
		return Num1;
	}
	
	public String getNum2() {
		return Num2;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	
	
}
