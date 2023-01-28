package exercise1;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card. 
 * To be used as starting code in Exercise
 *
 * @author dancye
 * @author Paul Bonenfant Jan 25, 2022
 * @author Aleksandar Manov Jan 27, 2023 
 */
public class CardTrick {
    
    public static void main(String[] args) {
        printRandomHand();
        System.out.println("\nNow!.. Let's play a little game!\n");
        cardGame();
    }

    /**
     * prints a hand of randomly generated cards.
     */
    private static void printRandomHand() {
        Card[] hand = new Card[7];

        for (int i = 0; i < hand.length; i++) {
            Card card = new Card();
            Random ran = new Random();

            card.setValue(card.randomCard());
            card.setSuit(Card.SUITS[ran.nextInt(3)]);
            hand[i] = card;
        }

        System.out.println("You were given the following random stack: ");

        for (Card myDeck : hand) {
            int myCards = myDeck.getValue();
            String mySuit = myDeck.getSuit();
            System.out.printf("\t %d of %s\n", myCards, mySuit);
        }
    }

    private static void cardGame() {
        Card[] hand = new Card[7];
        Card card = new Card();

        Scanner in = new Scanner(System.in);

        System.out.print("Pick a card, any card!\nEnter the Card: ");
        int userCard = in.nextInt();

        for (int i = 0; i < hand.length; i++) {
            Random ran = new Random();

            card.setValue(userCard);
            card.setSuit(Card.SUITS[ran.nextInt(3)]);
            hand[i] = card;
        }
        

        String cardString = "";
        switch(userCard) {
            case 1:
                cardString = "Ace";
                break;
            case 11:
                cardString = "Jack";
                break;
            case 12:
                cardString = "Queen";
                break;
            case 13:
                cardString = "King";
                break;
            case 14:
                cardString = "Joker";
                break;
        }

        System.out.println("\nPick a Suit.");
        System.out.println("1 = Hearts, 2 = Diamonds, 3 = Spades, 4 = Clubs");
        System.out.print("Suit: ");
        int userSuit = in.nextInt();
        
        while(userSuit > 4) {
            System.out.printf("%d is not part of the Suite!\n", userSuit);
            System.out.print("Try again: ");
            userSuit = in.nextInt();
            
            if (userSuit < 4) {
                continue;
            }
        }

        String suitString = "";
        switch(userSuit) {
            case 1:
                suitString = "Hearts";
                break;
            case 2:
                suitString = "Diamonds";
                break;
            case 3:
                suitString = "Spades";
                break;
            case 4:
                suitString = "Clubs";
                break;
        }

        if (userCard < 2 || userCard > 10) {
            System.out.printf("\nYou picked a %s of %s", cardString, suitString);
        } else { // anything between 2 and 10
            System.out.printf("\nYou picked a %d of %s", userCard, suitString);
        }

        System.out.println("\nLet's see if your card is in the magic hand!\n");

        for (Card myDeck : hand) {
            while (myDeck.getValue() > 14) {
                System.out.printf("Oh no! Unfortunately your %d was not in the magic hand!\nTry again: ", userCard);
                userCard = in.nextInt();
                if (userCard < 14) {
                    continue;
                }
            }
        }
        printInfo();
        in.close(); // we're done using the userInput, close() stream
    }

    /**
     * A simple method to print out personal information. Follow the instructions to 
     * replace this information with your own.
     * @author Paul Bonenfant Jan 2022
     */
    private static void printInfo() {
    
        System.out.println("Congratulations, you guessed right!");
        
        try {
            Thread.sleep(1000); // waits for the congratulations to display longer
        } catch(InterruptedException ex) {
            Thread.interrupted();
            System.out.println("Caught Thread Exception: " + ex.toString());
        }

        System.out.println();
        
        System.out.println("My name is Aleksandar, but you can call me Aleks");
        System.out.println();
        
        System.out.println("My career ambitions:");
        System.out.println("-- Be more active on LinkedIn");
        System.out.println("-- Become a member of the Software Development Field");
	    System.out.println();	

        System.out.println("My hobbies:");
        System.out.println("-- Coding");
        System.out.println("-- Gaming");
        System.out.println("-- Going to the gym");
        System.out.println("-- Learning new skills");
        System.out.println("-- Music (listening to it)");

        System.out.println();
        
    
    }

}
