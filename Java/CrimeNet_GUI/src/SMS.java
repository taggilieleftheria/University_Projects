public class SMS extends Communication {
	private String context;
	
	public SMS(String num1, String num2, int day, int month, int year, String content) {
		super(num1, num2, day, month, year);
	    this.context = content;
	}

	public void printInfo() {
		System.out.println("This SMS has the following info");
		super.printInfo();
		System.out.println("Text: " + context);;
	}

	public String getContext() {
		return context;
	}
	
	public String toString() {
		return context;
	}

}