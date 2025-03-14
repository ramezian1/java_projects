#  Blackjack Game (Java)

This repository contains a simple Blackjack game implemented in Java.

## 📍 Description

This Java program simulates a basic version of the Blackjack card game. Players can place bets, hit, stand, and double down against a dealer. The game includes insurance functionality and handles Blackjack payouts.

**Key Features:**

*  **Standard Blackjack Rules:** Implements core Blackjack rules, including hitting, standing, doubling down, and dealer's play.
*  **Insurance:** Offers insurance when the dealer shows an Ace.
* 🏷**Blackjack Payouts:** Pays 1.5x the bet for player Blackjack.
*  **Betting System:** Allows players to manage their balance and place bets.
*  **Hand Value Calculation:** Accurately calculates hand values, including flexible Ace values.
*  **User-Friendly Input:** Uses a `Scanner` for interactive gameplay via the console.

## 🚩 Gameplay

1.   **Start:** The player begins with a balance of $1000.
2.   **Betting:** The player enters a bet amount.
3.   **Dealing:** Two cards are dealt to the player and the dealer (one dealer card face down).
4.   **Insurance:** If the dealer's face-up card is an Ace, the player can buy insurance.
5.  🏷 **Player's Turn:** The player can choose to:
    *  **Hit:** Draw another card.
    *  **Stand:** Keep the current hand.
    *  **Double Down:** Double the bet and draw one more card.
6.   **Dealer's Turn:** The dealer reveals their hidden card and draws until their hand value is 17 or more.
7.  🏷 **Outcome:** The winner is determined based on hand values.
8.   **Payouts:**
    *  **Blackjack:** 1.5x bet.
    *  **Win:** 1x bet.
    *  **Insurance:** 2:1 if the dealer has Blackjack.
9.  **Game Over:** The game ends when the player's balance reaches $0.

## 🏷️ Usage

1.  📌 **Clone the Repository:**
    ```bash
    git clone github.com/ramezian1/java_projects/src/Blackjack
    ```
2.  📍 **Compile the Code:**
    ```bash
    javac blackjack/BlackjackGame.java
    ```
3.  🚩 **Run the Game:**
    ```bash
    java blackjack.BlackjackGame
    ```

## 🔑 Code Structure

* 📌 **`BlackjackGame.java`:** Contains the main game logic, including betting, dealing, player/dealer turns, and payout calculations.
* 📍 **`createDeck()`:** Creates a standard 52-card deck.
* 🚩 **`calculateHandValue()`:** Calculates the value of a hand.
* 🔖 **`getHandRanks()`:** Returns a string representation of a hand.

## 📌 Contributing

Contributions are welcome! Feel free to submit pull requests or open issues for bug fixes or feature requests.

## 📍 License

This project is licensed under Robert Mezian
