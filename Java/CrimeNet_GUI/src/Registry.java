import java.util.ArrayList;

public class Registry {
	private ArrayList<Suspect> enrolledSuspect;
	private ArrayList<Communication> Communications;
	
	public Registry() {
		enrolledSuspect = new ArrayList<>();
		Communications = new ArrayList<>();
	}
	
	public void addSuspect(Suspect aSuspect) {
		enrolledSuspect.add(aSuspect);
	}

	public void addCommunication(Communication aCommunication) {
        String num1, num2;
        Suspect s1 = null;
        Suspect s2 = null;
		
		Communications.add(aCommunication);
		
		num1 = aCommunication.getNum1();
		num2 = aCommunication.getNum2();
		
		for(int i=0; i<enrolledSuspect.size(); i++) { 
			for(String num : enrolledSuspect.get(i).getPhoneNumber()) {
				if(num1.equals(num)) {
					s1 = enrolledSuspect.get(i); 
				}
				else if(num2.equals(num)) {
					s2 = enrolledSuspect.get(i);	
				}
			}
			if(s1!=null && s2!=null) {
			    s1.addColleague(s2);
			    s2.addColleague(s1);
			}
		}
	} 
	
	public Suspect getSuspectWithMostPartners() {
		Suspect topSuspect = null;
		int max = 0;
		
		for(int i=0; i<enrolledSuspect.size(); i++) {
			if(enrolledSuspect.get(i).getPotentialPartners().size() >= max) {
				topSuspect = enrolledSuspect.get(i);
				max=enrolledSuspect.get(i).getPotentialPartners().size();
			}		
		}
		return topSuspect;
	}
	
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2) {
        PhoneCall best = null;
        int max = 0;
        
		for(int i=0; i<Communications.size(); i++) {
			if(Communications.get(i) instanceof PhoneCall) {
				if(Communications.get(i).getNum1().equals(number1) && Communications.get(i).getNum2().equals(number2)) {
					if(((PhoneCall) Communications.get(i)).getDuration() > max) {
						max = ((PhoneCall) Communications.get(i)).getDuration();
						best = (PhoneCall) Communications.get(i); 
					}
				}
			}
		
		}
		return best;
	}
	
	public ArrayList<SMS> getMessagesBetween(String number1, String number2) {
		ArrayList<SMS> SMSlist = new ArrayList<SMS>();
		
		for(int i=0; i<Communications.size(); i++) {
			if(Communications.get(i) instanceof SMS) {
				if(Communications.get(i).getNum1().equals(number1) && Communications.get(i).getNum2().equals(number2)) {
					if(((SMS) Communications.get(i)).getContext().contains("Bomb") || ((SMS) Communications.get(i)).getContext().contains("Attack") || ((SMS) Communications.get(i)).getContext().contains("Explosives") || ((SMS) Communications.get(i)).getContext().contains("Gun")) {
						SMSlist.add((SMS)Communications.get(i));
					}
				}
			}
			
		}
		return SMSlist;
	}

	public Suspect FindSuspect(String text) {
		for (Suspect s : enrolledSuspect) {
			if(s.getName().equals(text) || s.getCodeName().equals(text)) {
				return s;
			}
		}
		return null;
	}
	
}
