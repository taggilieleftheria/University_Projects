import java.util.ArrayList;

public class Suspect {
	private String name;
	private String codeName;
	private String city;
	private ArrayList<String> phoneNumber;
	private ArrayList<Suspect> potentialPartners = new ArrayList<Suspect>();
	private ArrayList<Suspect> commonPartners = new ArrayList<Suspect>();
	private ArrayList<Suspect> suggestedSuspects = new ArrayList<Suspect>();
	private String number; 
	
	public Suspect(String name, String codeName, String city) {
		this.name = name;
		this.codeName = codeName;
		this.city = city;
		phoneNumber = new ArrayList<>();
		potentialPartners = new ArrayList<>();
		commonPartners= new ArrayList<>();
	}
	
	public void addNumber(String number) {
		phoneNumber.add(number);
	}
	
	public void addColleague(Suspect partner) {
		if(!isConnectedTo(partner))
			potentialPartners.add(partner);
	}
	
	public boolean isConnectedTo(Suspect aSuspect) {
		if(potentialPartners.contains(aSuspect))
			return true;
		return false;
	}
	
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect) {
		for(int i=0; i<potentialPartners.size(); i++) {
			if(potentialPartners.get(i).isConnectedTo(aSuspect)) 
				commonPartners.add(potentialPartners.get(i));
		}
		return commonPartners;
	}
	
	public void printInfo( ) {
		for(Suspect i : potentialPartners) {
			System.out.println(i.name + ", " + i.codeName);
		}
	}

	public String getName() {
		return name;
	}

	public String getCodeName() {
		return codeName;
	}
	
	public String getCity() {
		return city;
	}

	public ArrayList<Suspect> getPotentialPartners() {
		return potentialPartners;
	}

	public ArrayList<String> getPhoneNumber() {
		return phoneNumber;
	}

	public ArrayList<Suspect> getCommonPartners() {
		return commonPartners;
	}
	
	public String toString() {	
		return  name  + " "
		+ ", "+ codeName   ;
							
	}
	public String toString1() {
		return number;
	}
	
	public ArrayList<Suspect> SuggestedSuspects(){
		for(Suspect s:potentialPartners) {
			for(Suspect sus :s.getPotentialPartners()) {
				if(!s.isConnectedTo(sus) && !sus.getName().equals(name)) {
					suggestedSuspects.add(sus);
					
				}			
			}
		}
		return suggestedSuspects;
	}
	
	public ArrayList<Suspect> getSuggestedSuspects(){
		return suggestedSuspects;
	}
	
}