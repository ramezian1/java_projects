package games_methods;

import java.util.*;

class Main {
  public static void main(String[] args) {

    int pmoney=100;

    Scanner s = new Scanner(System.in);
    	while(pmoney>0){
	      Deck deck=new Deck();
	      Hand dealer=new Hand(deck.getCard(),deck.getCard());
	      Hand player=new Hand(deck.getCard(),deck.getCard());
	      int bet=Integer.MAX_VALUE;
	
      while(bet>pmoney || bet<=0){ 
        System.out.println("Your money: "+pmoney+"\nEnter Valid Bet: ");
        bet=Integer.parseInt(s.nextLine());
        
        for(int i=0; i<50; i++) {
          System.out.print("\n");
        }
      }

      String move="";

      while(!(move.equals("Stand") || move.equals("Double Down")) && player.getValue()<=21){

        for(int i=0; i<50; i++){
			System.out.print("\n");
			
      }

      System.out.print("Your Bet: "+bet+"\nYour Money: "+pmoney+"\n");
      System.out.print("Hand: ");
      player.print();
      System.out.println("\nDealer: "+dealer.getHand().get(0).toString()+" ");
      System.out.println("Stand, Hit, or Double Down? (Case sensitive): ");


        move=s.nextLine();
        if(dealer.getValue()<17){
          dealer.addCard(deck.getCard());
        }

        if(move.equals("Hit")){
          player.addCard(deck.getCard());
        }

        if(move.equals("Double Down")){
          if(bet*2>pmoney){

            for(int i=0; i<50; i++){
              System.out.print("\n");
          }


            System.out.println("Not enough money to double down, enter different move");
            System.out.print("Your Bet: "+bet+"\nYour Money: "+pmoney+"\n");
            System.out.print("Hand: ");
            player.print();

            System.out.println("\nDealer: "+dealer.getHand().get(0).toString()+" ");
            System.out.println("Stand or Hit? (Case sensitive): ");
            move=s.nextLine();

          } 
		else {
            bet=bet*2;

          }
        }
      }

      while(dealer.getValue()<17){
        dealer.addCard(deck.getCard());
      }

      for(int i=0; i<50; i++) {
        System.out.print("\n");
      }

      if(dealer.getValue()>21 && player.getValue()>21) {

        System.out.println("The Bet: "+bet);
        System.out.print("Your Hand: ");
        player.print();
        System.out.print("\nDealer's Hand: ");
        dealer.print();
        System.out.println("");
        System.out.println("Both you and the dealer busted");
      } 
      else if (dealer.getValue()>21) {
        System.out.println("The Bet: "+bet);
        System.out.print("Your Hand: ");
        player.print();
        System.out.print("\nDealer's Hand: ");
        dealer.print();
        System.out.println("");
        System.out.println("The dealer busted! You win the bet!");
        pmoney+=bet;
      } else if(player.getValue()>21) {
        System.out.println("The Bet: "+bet);
        System.out.print("Your Hand: ");
        player.print();
        System.out.print("\nDealer's Hand: ");
        dealer.print();
        System.out.println("");
        System.out.println("You busted, dealer takes bet.");
        pmoney-=bet;
      } else if(player.getValue()==21 && dealer.getValue()==21) {
        if (player.getHand().size()==2 && dealer.getHand().size()==2) {
          System.out.println("The Bet: "+bet);
          System.out.print("Your Hand: ");
          player.print();
          System.out.print("\nDealer's Hand: ");
          dealer.print();
          System.out.println("");
          System.out.println("You and the dealer both had Blackjacks, it's a draw!");
        }
        
        else if(player.getHand().size()==2) {
          System.out.println("The Bet: "+bet);
          System.out.print("Your Hand: ");
          player.print();
          System.out.print("\nDealer's Hand: ");
          dealer.print();
          System.out.println("");
          System.out.println("You got a Blackjack! You win!");
          pmoney+=bet;
        }
        
        else if(dealer.getHand().size()==2){
          System.out.println("The Bet: "+bet);
          System.out.print("Your Hand: ");
          player.print();
          System.out.print("\nDealer's Hand: ");
          dealer.print();
          System.out.println("");
          System.out.println("The dealer got a Blackjack! You lose.");
          pmoney-=bet;
        }
      }
      else if(player.getValue()>dealer.getValue()){
        System.out.println("The Bet: "+bet);
        System.out.print("Your Hand: ");
        player.print();
        System.out.print("\nDealer's Hand: ");
        dealer.print();
        System.out.println("");
        System.out.println("You have a higher hand! You win!");
        pmoney+=bet;
      }
      else if(player.getValue()<dealer.getValue()){
        System.out.println("The Bet: "+bet);
        System.out.print("Your Hand: ");
        player.print();
        System.out.print("\nDealer's Hand: ");
        dealer.print();
        System.out.println("");
        System.out.println("The dealer has a higher hand! You lose.");
        pmoney-=bet;
      }
      else {
        System.out.println("The Bet: "+bet);
        System.out.print("Your Hand: ");
        player.print();
        System.out.print("\nDealer's Hand: ");
        dealer.print();
        System.out.println("\nIt's a draw!");
      }
      System.out.println("Press Enter to Continue");
      s.nextLine();
      for (int i=0; i<50; i++){
        System.out.print("\n");
      }
      System.out.print("Your money: "+pmoney+"\nKeep playing? (Y or N case sensitive) ");
      if (s.nextLine().equals("N")){
        
        break;
      }
    }
    for(int i=0; i<50; i++){
      System.out.print("\n");
    }
    System.out.println("\nYou ended up with "+pmoney+" dollars!");
    s.close();
    
    
    
  }
}
class Card {

    private int value;
    private String name;
    private String suit;
    public Card(int a, int b){
      switch(a){
        case 2:
          this.name="Two";
          this.value=2;
          break;
        case 3:
          this.name="Three";
          this.value=3;
          break;
        case 4:
          this.name="Four";
          this.value=4;
          break;
        case 5:
          this.name="Five";
          this.value=5;
          break;
        case 6:
          this.name="Six";
          this.value=6;
          break;
        case 7:
          this.name="Seven";
          this.value=7;
          break;
        case 8:
          this.name="Eight";
          this.value=8;
          break;
        case 9:
          this.name="Nine";
          this.value=9;
          break;
        case 10:
          this.name="Ten";
          this.value=10;
          break;
        case 11:
          this.name="Jack";
          this.value=10;
          break;
        case 12:
          this.name="Queen";
          this.value=10;
          break;
        case 13:
          this.name="King";
          this.value=10;
          break;
        case 14:
          this.name="Ace";
          this.value=11;
          break;
        default:
          this.value=-1;
          this.name="Unknown";
      }
      switch(b){
        case 1:
          this.suit="Spades";
          break;
        case 2:
          this.suit="Hearts";
          break;
        case 3:
          this.suit="Clubs";
          break;
        case 4:
          this.suit="Diamonds";
          break;
          
        default:
          this.name="Unknown";
      }
    }
    public void print(){
      System.out.print(this.name+" of "+this.suit);
    }
    public int getValue(){
      return this.value;
    }
    public String toString(){
      return this.name+" of "+this.suit;
    }
  }
class Deck {
  
  private ArrayList<Card> deck;
  public Deck(){
    deck=new ArrayList<Card>();
    for(int i=2; i<15; i++){
      for(int j=1; j<5; j++){
        Card c=new Card(i,j);
        deck.add(c);
      }
    }
  }
  public Card getCard(){
    int i=(int)(Math.random()*deck.size());
    Card r=deck.get(i);
    deck.remove(i);
    return r;
  }
}
  class Hand {
    private ArrayList<Card> hand;
    private int value;
    private int aces=0;
    public Hand(Card a, Card b){
      hand=new ArrayList<Card>();
      hand.add(a);
      hand.add(b);
      if(a.getValue()==14){
        aces++;
      }
      if(b.getValue()==14){
        aces++;
      }
      this.value=hand.get(0).getValue()+hand.get(1).getValue();
    }
    public void addCard(Card a){
      if(a.getValue()==11){
        aces++;
      }
      this.value+=a.getValue();
      if(value>21){
        while(value>21 && aces>0){
          value-=10;
          aces--;
        }
      }
      hand.add(a);
    }
    public void print(){
      for(int i=0; i<hand.size()-1; i++){
        hand.get(i).print();
        System.out.print(" , ");
      }
      hand.get(hand.size()-1).print();
    }
    public int getValue(){
      return this.value;
    }
    public ArrayList<Card> getHand(){
      return this.hand;
    }
  }
