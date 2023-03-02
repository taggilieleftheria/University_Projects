import java.util.Random;

public class Dealer {
	private int total;
	private int card1;
	private int card2;
	private int numberofcards;
	private int Card[] ;
	
	public Dealer() {
		total=0;
		numberofcards=0;
	}
	
	
	public void getTotal(int card1, int card2) {
		total=total+(card1+card2);
		while(total<21) {
			card1=(int )(Math.random() *10);
			card2=(int )(Math.random() *10);
			total=total+(card1+card2);
		}
		if (total>21) {
			System.out.println("The player wins!!");
		}
	}
	
	public void getHiddenCard(int card) {
		System.out.printf("His hidden card is ");
		System.out.print(card);
		
		
	}
	
	public int getHisTotal(int card1,int card2,int total) {
		total=total+card1+card2;
		return total;
		
	}
	
	public int getAnswerDealer(String answer,int total) {
		Card cards= new Card();
		int carddealer = 0;
		
		String s="stay";
		String s1="hit";
		if(answer.equals(s1)) {
			carddealer=cards.getCard1();
			System.out.printf("You drew a ");
			System.out.print(carddealer);
			System.out.println();
			System.out.print("Your total is ");
		    total=total+carddealer;
			System.out.print(total);
			System.out.println();
		}
		
			return carddealer;
	}
	
	public int getSecondTotal(int card,int total) {
		total=total+card;
		return total;
	}

}
