import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int dcard1,dcard2,pcard1,pcard2,dtotal = 0,ptotal=0;
		Player player = new Player();
		Dealer dealer = new Dealer();
		String answer;
		int acard,carddealer;
		boolean flag;
		String s2="hit";
		String s1="stay";
		Card cards = new Card();
		System.out.println("Welcome to the simplefied Blackjack game!");
		//the player get 2 cards
		pcard1=cards.getCard1();
		pcard2=cards.getCard2();
		System.out.printf("You get a ");
		System.out.print(pcard1 );
		System.out.printf(" and a ");
		System.out.print(pcard2);
		System.out.println();
		//the sum of the 2 cards
		ptotal=cards.getTotal(pcard1, pcard2);
		System.out.print("Your total is ");
		System.out.print(ptotal);
		System.out.println();
		dcard1=cards.getCard1();
		dcard2=cards.getCard2();
		System.out.printf("The dealer has a  ");
		System.out.print(dcard1);
		System.out.printf(" showing,and a hidden card." );
		System.out.println();
		System.out.println("Would you like to �hit� or �stay�? ");
		answer=keyboard.nextLine();
		//asks if the player wants to continue playing
		while (answer.equals(s2)) {
			acard=player.getAnswer(answer, ptotal);
			ptotal=player.getPlayerTotal(acard, ptotal);
			
			
			if(answer.equals(s1)) {
				flag=false;
			}
			if (ptotal>21) {
				System.out.println("Player lose");
				break;
			}
			
			System.out.println("Would you like to �hit� or �stay�? ");
			answer=keyboard.nextLine();
			
		}
		if(answer.equals(s1)) {
				carddealer=dealer.getAnswerDealer(answer, dtotal);
				dealer.getHiddenCard(dcard2);
				dtotal=dealer.getHisTotal( dcard1,dcard2, dtotal);
				System.out.println();
				System.out.print("His total is ");
				System.out.print(dtotal);
				System.out.println();
				System.out.println("Would you like to �hit� or �stay�? ");
				answer=keyboard.nextLine();
				while (answer.equals(s2)) {
					carddealer=dealer.getAnswerDealer(answer, dtotal);
					dtotal=dealer.getSecondTotal(carddealer, dtotal);
					if(answer.equals(s1)) {
						flag=false;
					}
					
					if (dtotal>21) {
						System.out.println("Dealer lose! ");
						break;
					}
					
					System.out.println("Would you like to �hit� or �stay�? ");
					answer=keyboard.nextLine();
				}
		}
			
		cards.getWinner(ptotal, dtotal);
		
	}

}
