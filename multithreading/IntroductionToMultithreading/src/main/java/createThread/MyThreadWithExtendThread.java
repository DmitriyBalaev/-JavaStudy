package createThread;

public class MyThreadWithExtendThread extends Thread{

    @Override
    public void run(){
        System.out.println("start myTread");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish myTread");
    }

    public static void main(String[] args) {
        Thread myThread = new MyThreadWithExtendThread();

        myThread.start();
    }
}
