import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Bank sb = new Bank();
        sb.initBank(100);

        System.out.println("In bank " + sb.getMoneyInBank());

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 12; i++)
        {
            threads.add(new Thread(sb));
        }

        threads.forEach(t -> t.start());

        System.out.println("In bank " + sb.getMoneyInBank());
    }
}
