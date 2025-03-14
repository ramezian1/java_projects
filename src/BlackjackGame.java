import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BlackjackGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerBalance = 1000;

        System.out.println("Welcome to Blackjack!");

        while (playerBalance > 0) {
            System.out.println("Your current balance: $" + playerBalance);
            System.out.print("Enter your bet: $");
            int bet = scanner.nextInt();

            if (bet <= 0 || bet > playerBalance) {
                System.out.println("Invalid bet. Please enter a bet between $1 and $" + playerBalance);
                continue;
            }

            List<String> deck = createDeck();
            Collections.shuffle(deck);

            List<String> playerHand = new ArrayList<>();
            List<String> dealerHand = new ArrayList<>();

            playerHand.add(deck.remove(0));
            dealerHand.add(deck.remove(0));
            playerHand.add(deck.remove(0));
            dealerHand.add(deck.remove(0));

            System.out.println("Your hand: " + getHandRanks(playerHand) + " = " + calculateHandValue(playerHand));
            System.out.println("Dealer's hand: " + dealerHand.get(0) + ", [Hidden Card]");

            // Insurance logic
            if (dealerHand.get(0).startsWith("Ace")) {
                System.out.print("Dealer shows an Ace. Buy insurance? (y/n): ");
                String insuranceChoice = scanner.next();
                if (insuranceChoice.equalsIgnoreCase("y")) {
                    int insuranceBet = bet / 2;
                    playerBalance -= insuranceBet;
                    System.out.println("You bought insurance for $" + insuranceBet);
                    if (calculateHandValue(dealerHand) == 21) {
                        System.out.println("Dealer has Blackjack! Insurance pays 2:1");
                        playerBalance += insuranceBet * 3; // 2:1 payout + original insurance bet
                    } else {
                        System.out.println("Dealer does not have Blackjack! Insurance Lost.");
                    }
                }
            }

            if (calculateHandValue(playerHand) == 21) {
                System.out.println("Blackjack! You win!");
                playerBalance += (int) (bet * 1.5);
            } else if (calculateHandValue(dealerHand) == 21) {
                System.out.println("Dealer Blackjack! You lose!");
                playerBalance -= bet;
            } else {
                // Game logic
                boolean playerTurn = true;
                boolean doubledDown = false;

                while (playerTurn) {
                    System.out.print("Hit, Stand, or Double Down? (h/s/d): ");
                    String choice = scanner.next();

                    if (choice.equalsIgnoreCase("h")) {
                        playerHand.add(deck.remove(0));
                        System.out.println("Your hand: " + getHandRanks(playerHand) + " = " + calculateHandValue(playerHand));
                        if (calculateHandValue(playerHand) > 21) {
                            System.out.println("Bust! You lose.");
                            playerBalance -= bet;
                            playerTurn = false;
                        }
                    } else if (choice.equalsIgnoreCase("s")) {
                        playerTurn = false;
                    } else if (choice.equalsIgnoreCase("d") && !doubledDown) {
                        if(playerBalance >= bet * 2){
                            playerBalance -= bet;
                            bet *= 2;
                            playerHand.add(deck.remove(0));
                            System.out.println("Your hand: " + getHandRanks(playerHand) + " = " + calculateHandValue(playerHand));
                            if (calculateHandValue(playerHand) > 21) {
                                System.out.println("Bust! You lose.");
                                playerBalance -= bet;
                            }
                            playerTurn = false;
                            doubledDown = true;
                        } else{
                            System.out.println("Insufficient funds for double down.");
                        }

                    } else {
                        System.out.println("Invalid choice.");
                    }
                }

                if (calculateHandValue(playerHand) <= 21) {
                    System.out.println("Dealer's turn.");
                    System.out.println("Dealer's hand: " + getHandRanks(dealerHand) + " = " + calculateHandValue(dealerHand));
                    while (calculateHandValue(dealerHand) < 17) {
                        dealerHand.add(deck.remove(0));
                        System.out.println("Dealer's hand: " + getHandRanks(dealerHand) + " = " + calculateHandValue(dealerHand));
                    }

                    int playerValue = calculateHandValue(playerHand);
                    int dealerValue = calculateHandValue(dealerHand);

                    if (dealerValue > 21 || playerValue > dealerValue) {
                        System.out.println("PLAYER WINS!!!");
                        playerBalance += bet;
                    } else if (playerValue < dealerValue) {
                        System.out.println("DEALER WINS!");
                        playerBalance -= bet;
                    } else {
                        System.out.println("Push! (Tie)");
                    }
                }
            }

            if (playerBalance <= 0) {
                System.out.println("You are out of money. Please restart the game to play again.");
            }
        }
        scanner.close();
    }

    private static List<String> createDeck() {
        List<String> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }
        return deck;
    }

    private static int calculateHandValue(List<String> hand) {
        int value = 0;
        int aceCount = 0;

        for (String card : hand) {
            String rank = card.split(" ")[0];
            if (rank.equals("Ace")) {
                value += 11;
                aceCount++;
            } else if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
                value += 10;
            } else {
                value += Integer.parseInt(rank);
            }
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    private static String getHandRanks(List<String> hand) {
        List<String> ranks = new ArrayList<>();
        for (String card : hand) {
            ranks.add(card.split(" ")[0]);
        }
        return ranks.toString();
    }
}
