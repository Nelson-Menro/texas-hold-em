package poker;
public class PokerHandEvaluator 
{
	
	public static boolean hasPair(Card[] cards) 
	{
		boolean hasPair = false;
		int [] cardValues = new int[13];
		
		for(int i = 0; i < 5;i++) //loop through cards
		{
			cardValues[cards[i].getValue() - 1]++;
		}
		for(int i = 0; i < cardValues.length; i++) //looping through cardValues 
		{
			if(cardValues[i] >= 2) //if element is 2, means two cards have that value
			{
				hasPair = true;
				break;
			}
			else
			{
				hasPair = false;
			}
		}
		return hasPair;
	}
	
	public static boolean hasTwoPair(Card[] cards) 
	{		
		int pairCounter = 0;
		int[] cardValues = new int[13];

		for (int i = 0; i < 5; i++) // loop through cards
		{
			cardValues[cards[i].getValue() - 1]++;
		}
		for (int i = 0; i < cardValues.length; i++) // looping through cardValues
		{
			if (cardValues[i] >= 2) // if element is 2, means two cards have that value
			{
				pairCounter++;
			} 
		}
		
		if(pairCounter == 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public static boolean hasThreeOfAKind(Card[] cards)
	{
		boolean hasThreeOfAKind = false;
		int [] cardValues = new int[13];
		
		for(int i = 0; i < 5; i++) //loop through cards
		{
			cardValues[cards[i].getValue() - 1]++;
		}
		for(int i = 0; i < cardValues.length; i++) //looping through cardValues 
		{
			if(cardValues[i] >= 3) //if element is 2, means two cards have that value
			{
				hasThreeOfAKind = true;
				break;
			}
			else
			{
				hasThreeOfAKind = false;
			}
		}
		return hasThreeOfAKind;
	}
	
	public static boolean hasStraight(Card[] cards)
	{
		int cardsInARow = 1;
		int[] cardValues = new int[14];

		for (int i = 0; i < 5; i++) // loop through cards
		{
			cardValues[cards[i].getValue() - 1]++;
		}
		
		//making ace equal value 14, index 13 
		cardValues[13] = cardValues[0]; 
		
		for (int i = 0; i < cardValues.length - 1; i++) // looping through cardValues
		{
			if (cardValues[i] == cardValues[i + 1] && cardValues[i] != 0 && cardValues[i + 1] != 0) // if element is 2, means two cards have that value
			{
				cardsInARow++;
			}
		}
		if (cardsInARow == 5) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}

	public static boolean hasFlush(Card[] cards)
	{
		boolean flush = true;
		for(int card = 0 ; card < cards.length - 1; card++)
		{
			if(cards[card].getSuit() !=  cards[card + 1].getSuit()) 
			{
				flush = false;
			}
		}
		return flush;
	}
	
	public static boolean hasFullHouse(Card[] cards)
	{
		boolean hasThreeOfAKind = false;
		boolean hasPair = false;
		int [] cardValues = new int[13];
		
		for(int i = 0; i < cards.length; i++) //loop through cards
		{
			cardValues[cards[i].getValue() - 1]++;
		}
		for(int i = 0; i < cardValues.length; i++) //looping through cardValues 
		{
			if(cardValues[i] == 2) //if element is 2, means two cards have that value
			{
				hasPair = true;
				break;
			}
		}
		for(int i = 0; i < cardValues.length; i++) //looping through cardValues 
		{
			if(cardValues[i] == 3) //if element is 2, means two cards have that value
			{
				hasThreeOfAKind = true;
				break;
			}
		}
		if(hasThreeOfAKind && hasPair)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean hasFourOfAKind(Card[] cards)
	{
		boolean hasFourOfAKind = false;
		int [] cardValues = new int[13];
		
		for(int i = 0; i < 5; i++) //loop through cards
		{
			cardValues[cards[i].getValue() - 1]++;
		}
		for(int i = 0; i < cardValues.length; i++) //looping through cardValues 
		{
			if(cardValues[i] == 4) //if element is 2, means two cards have that value
			{
				hasFourOfAKind = true;
				break;
			}
			else
			{
				hasFourOfAKind = false;
			}
		}
		return hasFourOfAKind;
		
	}
	
	public static boolean hasStraightFlush(Card[] cards)
	{
		if(PokerHandEvaluator.hasStraight(cards) && PokerHandEvaluator.hasFlush(cards))
		{
			return true;
		}
		return false;
	}
}

