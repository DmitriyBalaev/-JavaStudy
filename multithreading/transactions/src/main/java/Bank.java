import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Bank implements Runnable{
    private final Random random = new Random();
    private HashMap<Long, Account> accounts = new HashMap<>();
    private long moneyInBank = 0;

    public synchronized boolean isFraud(Long fromAccountNum, Long toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(Long fromIdAccount, Long toIdAccount, long amount) throws InterruptedException {
        boolean isBlockedAccountFrom = accounts.get(fromIdAccount).isBlocked();
        boolean isBlockedAccountTo = accounts.get(toIdAccount).isBlocked();
        boolean isCorrectAmount = amount < accounts.get(fromIdAccount).getBalance();

        if (!isBlockedAccountFrom && !isBlockedAccountTo && isCorrectAmount){
            if (amount > 50000){
                if (!isFraud(fromIdAccount, toIdAccount, amount)){
                    accounts.get(fromIdAccount).withdrawal(amount);
                    accounts.get(toIdAccount).replenishment(amount);
                    System.out.printf("Successful!\n%s --> %s\n",accounts.get(fromIdAccount), accounts.get(toIdAccount));
                }else {
                    accounts.get(fromIdAccount).banned();
                    accounts.get(toIdAccount).banned();
                    System.out.printf("%s and %s blocked by security service\n", accounts.get(fromIdAccount), accounts.get(toIdAccount));
                }
            }else {
                accounts.get(fromIdAccount).withdrawal(amount);
                accounts.get(toIdAccount).replenishment(amount);
                System.out.printf("Successful!\n%s --> %s\n",accounts.get(fromIdAccount), accounts.get(toIdAccount));
            }
        }else {
            System.out.printf("Transfer failed. Transfer information:\nAccountFrom is block - %s\nAccountTo is block - %s\ntransfer amount: %s\n",
                   accounts.get(fromIdAccount).isBlocked(), accounts.get(toIdAccount).isBlocked(), amount);
        }
    }
    
    public void initBank(int countAccount){
        for (int i = 0; i < countAccount ; i++) {
            Account newAccount = new Account();
            accounts.put(newAccount.getId(), newAccount);
            moneyInBank += newAccount.getBalance();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("================Перевод %s===================\n", i);
            long fromAccount = (long) (Math.random() * accounts.size());
            long toAccount = (long) (Math.random() * accounts.size());
            int amount = (int) (1000 + Math.random() * 200000);

            try {
                transfer(fromAccount, toAccount, amount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long getMoneyInBank() {
        return moneyInBank;
    }
}
