package beginner_java;


class BankAccount {

    String user;
    long numberacc;
    String due;

    public BankAccount(String user, long numberacc, String due) {

        this.user = user;
        this.numberacc = numberacc;
        this.due = due;

        System.out.println("THE CREDIT CARD STATEMENT ARE AS FOLLOWS ");
		System.out.println("----------------------");
		System.out.println("ACCOUNT NUMBER: " + numberacc);
		System.out.println("--");
		System.out.println("Customer Name: " + user);
		System.out.println("--");
		System.out.println("Due Date: " + due);
		System.out.println("--");
    }

    public void CreditCharge (int charge) {
        System.out.println("Credit Card has been charged with a fee of $" + charge);
        System.out.println("--");
    }

    public void Cash_Adv (int Cash_Adv) {
        System.out.println("A Cash Adanvance was issued on your credit card with a total of $" + Cash_Adv);
        System.out.println("--");
    }

    public void paid (int payment) {
        System.out.println("Payment of $" + payment + " has been made.");
        System.out.println("--");
    
    }

    }

class Accounts {
    public static void main (String [] args) {

        BankAccount ba = new BankAccount("Bobby", 325155, "28th of every Month");

        ba.CreditCharge(300);
        ba.Cash_Adv(100);
        ba.paid(50);
      


    }
    
}