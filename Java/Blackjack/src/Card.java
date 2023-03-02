import java.util.Random;

public class Card {
	private int card1;
	private int card2;
	private int total;

	
	public int getCard1() {
	
		card1=(int )(Math.random() *10);
		return card1;
	}
	
	public int getCard2() {
		
		card2=(int )(Math.random() *10);
		return card2;
		
	}
	
	public int getTotal(int card1, int card2) {
		total=total+(card1+card2);
		return total;
	}
	
	public void getWinner(int ptotal,int dtotal) {
		if (ptotal>21) {
			System.out.println("DEALER WINS!");
		}else if (ptotal<=21 && ptotal>dtotal) {
			System.out.println("PLAYER WINS!!!");
		}else if(dtotal>ptotal && dtotal<=21) {
			System.out.println("DEALER WINS!!!");
		}else if (dtotal>21) {
			System.out.println("PLAYER WINS!");
		
		}
	}


}
