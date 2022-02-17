import java.util.logging.Logger;

public class Account implements Comparable<Account> {
    private Long id;
    private long balance;
    private boolean isBlocked;
    private static long count = 0;

    public Account(){
        id = count++;
        balance = (long) (5000 + Math.random() * 150000);
    }

    public double getBalance() {
        return balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void banned(){
        isBlocked = true;
    }

    public void unBanned(){
        isBlocked = false;
    }

    public long getId() {
        return id;
    }


    public synchronized void withdrawal(double amount) {
        if (isBlocked){
            System.out.println("Account blocked");
        }else if (amount >= balance){
            System.out.println("Withdrawal amount exceeds your balance");
        }else {
            balance -= amount;
        }
    }

    public synchronized void replenishment(double amount) {
       if (isBlocked) {
           System.out.println("Account blocked");
       }else if(amount < 0) {
           System.out.println("The amount cannot be negative.");
       }else {
           balance += amount;
       }
      }

    @Override
    public String toString() {
        return String.format("Account [id: %s; balance: %s]", id, balance);
    }

    @Override
    public int compareTo(Account account) {
        return this.id.compareTo(account.id);
    }
}
