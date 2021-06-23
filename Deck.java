package poker;

public class Deck 
{
	private Card[] cards; //first Card in the array will be considered the card that is at the top of the deck. 
											//When cards are removed from the deck they will be removed from the front of the array. 
	private final static int fullDeck = 52;
	
	//constructor for student Tests 
	public Deck(Card[] otherCards) 
	{
		this.cards = otherCards;
	}
	public Deck()  
	{
		cards = new Card[fullDeck]; //initialized card array to 52 
		
		int index = 0;
		for(int suit = 0;  suit <= 3; suit++)
		{
			for(int value = 1; value <= 13; value++)
			{
				cards[index++] =  new Card(value, suit);
			}
		}
	}

	public Deck(Deck other)
	{	
		Card[] copy = new Card[other.getNumCards()];
		
		for(int i = 0; i < copy.length; i++)
		{
			copy[i] = other.cards[i];
		}
		this.cards = copy;
	}

	public Card getCardAt(int position)
	{
		return cards[position]; //Returns the card that is at the specified position in the array. (Uses the usual 0-based indexing.)
	}

	public int getNumCards() 
	{
		return cards.length;
	}

	public void shuffle() 
	{
		int indexOne = 0, indexTwo = cards.length/2;
		Card[] shuffledDeck  = new Card [cards.length];
		
		if(cards.length % 2 == 0)
		{
			for(int i = 0; i <= cards.length-1; i+=2) 
			{
				shuffledDeck[i] = cards[indexOne];
				shuffledDeck[i+1] = cards[indexTwo];
				indexTwo++;
				indexOne++;
			}
		}
		else 
		{
			indexTwo = cards.length/2 + 1;
			for(int i = 0; i <= cards.length; i+=2) 
			{
				if(i != cards.length - 1)
				{
				shuffledDeck[i] = cards[indexOne];
				shuffledDeck[i+1] = cards[indexTwo];
				indexTwo++;
				indexOne++;
				}
				else
				{
					shuffledDeck[i] = cards[indexOne];
				}
			}
		}
		this.cards = shuffledDeck;
	}
 
	public void cut(int position)  
	{
		for (int i = 0; i < position; i++) 
		{
			Card temp = cards[0]; //take first element 
			for (int j = 0; j < cards.length - 1; j++)  //loop through and shift element
			{
				cards[j] = cards[j + 1];
			}
			cards[cards.length - 1] = temp;
		}
	}


	public Card[] deal(int numCards) 
	{
		Card[] cardsDealt = new Card[numCards]; //cards dealt, to return 
		Card[] smaller = new Card[getNumCards() - numCards]; //Make a new array (call it "smaller") that is the same size as the current deck of cards minus the number of cards being dealt.
		
		
		for(int counter = 0; counter < smaller.length; counter++) //copying elements into new array
		{
			smaller[counter] = cards[numCards]; //	Copy the cards that are not being dealt from the original array into the new one.
			numCards++;
		}
		for(int i = 0; i < cardsDealt.length; i++) //creating new array to return 
		{
			cardsDealt[i] = cards[i];
		}
		
		this.cards = smaller; 	//Assign the instance variable "cards" so that it refers to the new array.
		return cardsDealt;
	}
		
	public String toString()
	{
		String s = "";

		for (int i = 0; i < cards.length; i++)
		{
			s += (cards[i] + " ");
			if(i > 0 && i % 13 == 0)
			{
				s += "\n";
			}
		}
		return s;
	}
}
