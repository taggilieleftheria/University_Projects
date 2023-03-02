import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Registry    {
	
	
	
	private String num1;
	private String num2;
	private int day;
	private int month;
	private int year;
	private int duration;
	private String Messege;
	private ArrayList<Suspect> suspect= new ArrayList<>();
	private ArrayList<String> PhoneNumbers;
	private ArrayList<Suspect> Suspects;
	private ArrayList<Communication> communicationsList = new ArrayList<>();
	
	
	public void addSuspect(Suspect s1) {
		
		suspect.add(s1);
	}
	
	public void addCommunication(Communication communication) {
		communicationsList.add(communication);
		
	}

	public Suspect getSuspectWithMostPartners() {
		int Maxsuspect = suspect.get(0).partnersArraylistSize();
		Suspect susp = suspect.get(0);
		for(int i=1;i<suspect.size();i++) {
			if(suspect.get(i).partnersArraylistSize() >= Maxsuspect) {
				Maxsuspect=suspect.get(i).partnersArraylistSize();
				susp = suspect.get(i);
			}
		}
		return susp;		
		
	}

	public ArrayList<String> getPhoneNumbers() {
		return PhoneNumbers;
	}

	public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
		PhoneNumbers = phoneNumbers;
	}

	public ArrayList<Suspect> getSuspects() {
		return Suspects;
	}

	public void setSuspects(ArrayList<Suspect> suspects) {
		Suspects = suspects;
	}

	

	public void setPropablySuspects(ArrayList<Suspect> propablySuspects) {
		suspect= propablySuspects;
	}

	public ArrayList<Communication> getCommunicationsList() {
		return communicationsList;
	}

	public void setCommunicationsList(ArrayList<Communication> communicationsList) {
		this.communicationsList = communicationsList;
	}

	public PhoneCall getLongestPhoneCallBetween(String Num1, String Num2) {
		PhoneCall pmax =(PhoneCall) communicationsList.get(0);
		int max=0;
		for(int i=1;i<communicationsList.size();i++) {
			if(communicationsList.get(i).getClass().equals(PhoneCall.class)) {
				PhoneCall temporary = (PhoneCall) communicationsList.get(i);
				String num1 = communicationsList.get(i).getNum1();
				String num2 = communicationsList.get(i).getNum2();
				if (Num1.equals(num1) && Num2.equals(num2) && temporary.getDuration()>max) {
					max=temporary.getDuration();
					pmax=temporary;
					
				}
			}
		}
		return pmax;
	}

	public ArrayList<SMS> getMessagesBetween(String Num1, String Num2) {
		ArrayList<SMS> sms = new ArrayList<SMS>();
		for(int i=0;i<communicationsList.size();i++) {
			 String num1 = communicationsList.get(i).getNum1();
			 String num2 = communicationsList.get(i).getNum2();
		if (communicationsList.get(i).getClass().equals(SMS.class) && Num1.equals(num1) && Num2.equals(num2) ){
			 SMS sms1 = (SMS)communicationsList.get(i);
			if (sms1.getContentofMessege().contains((CharSequence) "Bomb")|| sms1.getContentofMessege().contains((CharSequence) "Attack") || sms1.getContentofMessege().contains((CharSequence) "Explosives") || sms1.getContentofMessege().contains((CharSequence) "Gun"))
					sms.add(sms1);
				}
			}
	return sms;
	}
	
	
	public ArrayList<Suspect> getSuspects(ArrayList<Suspect> suspects) {
		Suspects = suspects;
		return Suspects;
	}
	

	

}