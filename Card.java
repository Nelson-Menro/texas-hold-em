package poker;
/**
 * An immutable class representing a playing card from a standard deck.
 * Each card has a value and a suit.
 * 
 */
public class Card {

	private final int suit;   // 0, 1, 2, 3 represent Spades, Hearts, Clubs, 
							  // Diamonds, respectively
	
	private final int value;  // 1 through 13 (1 is Ace, 11 is jack, 12 is 
	                          // queen, 13 is king, 2 through 10 represent
	                          // card values 2 through 10.)
	
	
	
	private final static String[] suitNames = {"s", "h", "c", "d"};
	private final static String[] valueNames = {"Unused", "A", "2", "3", "4", 
		"5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	/**
	 * Standard constructor.
	 */
	public Card(int value, int suit) {
		if (value < 1 || value > 13) {
			throw new RuntimeException("Illegal card value attempted.  The " +
					"acceptible range is 1 to 13.  You tried " + value);
		}
		if (suit < 0 || suit > 3) {
			throw new RuntimeException("Illegal suit attempted.  The  " + 
					"acceptible range is 0 to 3.  You tried " + suit);
		}
		this.suit = suit;
		this.value = value;
	}

	/** 
	 * "Getter" for value of Card.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * "Getter" for suit of Card.
	 */
	public int getSuit() {
		return suit;
	}
	
	/** Returns the name of the card as a String. 
	 */
	public String toString() {
		return valueNames[value] + " of " + suitNames[suit];
	}
	
	/**
	 * Used for finding the image corresponding to this Card.
	 * @return path of image file corresponding to this Card.
	 */
	public String getImageFileName() {
		
		String retValue;
		retValue = suitNames[suit];
		if (value <= 10)
			retValue += value;
		else if (value == 11)
			retValue += "j";
		else if (value == 12)
			retValue += "q";
		else if (value == 13)
			retValue += "k";
		else 
			retValue += "Unknown!";
		return "images/" + retValue + ".gif";	
	}
}