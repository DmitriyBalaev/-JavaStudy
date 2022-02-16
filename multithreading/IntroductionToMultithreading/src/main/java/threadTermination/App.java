package threadTermination;

import java.util.TreeMap;

public class App {

    public static void main(String[] args) throws InterruptedException {
        System.out.printf("%s started\n", Thread.currentThread().getName());
        MyTread r = new MyTread();
        Thread myThread = new Thread(r, "myThread");

        myThread.start();

        Thread.sleep(60);
        myThread.interrupt();
        System.out.printf("%s finish\n", Thread.currentThread().getName());

    }
}
class MyTread implements Runnable{

    @Override
    public void run() {
        System.out.printf("%s start\n", Thread.currentThread().getName());
        int count = 1;

        while (!Thread.currentThread().isInterrupted()){
            System.out.println("loop " + count++);
        }
        System.out.printf("%s finish\n", Thread.currentThread().getName());
    }
}
