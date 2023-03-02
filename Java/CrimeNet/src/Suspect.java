import java.util.ArrayList;

public class Suspect  {
	
	private String Name;
	private String phonenumbers;
	private String NickName;
	private String Country;
	private ArrayList<String> phoneNumbers = new ArrayList<>();
	private ArrayList<Suspect> partners = new ArrayList<>();
	

	
public Suspect(String name, String nickName, String country) {
		
		this.Name = name;
		this.NickName = nickName;
		this.Country = country;
	}

public void addNumber(String phonenumbers) {
	phoneNumbers.add(phonenumbers);
}

public void addPartners(Suspect aSuspect) {
	
		if(!(Name.equals(aSuspect.Name))){	
			for (Suspect sus:partners) {
				if(!sus.Name.equals(aSuspect.Name)) {
					partners.add(aSuspect);
				}
			}
		
		}
}


public boolean isConnectedTo(Suspect s) {
	for (Suspect sus:partners) {
			if(sus.Name.equals(s.Name)) {
	        	   return true;
	        	  
	           }
	}
		
       return false;
	 
}

public String getCodeName() {
	
	return NickName;
}

public String getName() {
	
	return Name;
}

public ArrayList<Suspect> getCommonPartners(Suspect s3) {
	ArrayList<Suspect> commonpartners = new ArrayList<Suspect>();
	for (Suspect sus:this.partners) {
		Suspect common= sus;
			if(sus.isConnectedTo(s3)){
				commonpartners.add(s3);
			}
	}
	return commonpartners;
	}
	


	
public int getCommonsize() {
	return this.partners.size();
}

public ArrayList<String> getNumbers(){
	return phoneNumbers;
}

public int partnersArraylistSize() {
	return partners.size();
}



public ArrayList<Suspect> getPartners() {
	return partners;
}

public void setPartners(ArrayList<Suspect> partners) {
	this.partners = partners;
}
 public String toString () {
	 return Name;
 }



}