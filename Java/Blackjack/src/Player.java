import java.util.Scanner;

public class Player {
	private int total;
	private int numberofcards;
	
	public Player() {
		total=0;
		numberofcards=0;
	}
	
	public int getAnswer(String answer,int total) {
		Card cards= new Card();
		int acard = 0;
		
		String s="stay";
		String s1="hit";
		if(answer.equals(s1)) {
			acard=cards.getCard1();
			System.out.printf("You drew a ");
			System.out.print(acard);
			System.out.println();
			System.out.print("Your total is ");
		    total=total+acard;
			System.out.print(total);
			System.out.println();
		}
		if (answer.equals(s) ) {
			System.out.println("Ok,dealer is playing.");
			
		}
			return acard;
		}
		
	public int getPlayerTotal(int card, int total) {
		total=total+card;
		return total;
	}
}
