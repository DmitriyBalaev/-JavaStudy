package createThread;

public class MyThreadWithImplRun implements Runnable{

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
}
