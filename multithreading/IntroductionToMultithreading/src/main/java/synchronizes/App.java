package synchronizes;

import createThread.MyThreadWithExtendThread;

import java.util.TreeMap;

import static java.lang.Thread.sleep;

public class App {
    public static void main(String[] args) {
        Resource r = new Resource();

        for (int i = 0; i < 6; i++) {
            Thread t = new Thread(new ThreadWithResource(r), "Thread " + i);
            t.start();
        }
    }
}
class Resource{
     int  x;

}

class ThreadWithResource implements Runnable {
    private Resource res;

    public ThreadWithResource(Resource res) {
        this.res = res;
    }

    @Override
    public void run(){
        synchronized (res) {
            res.x = 1;
            for (int i = 0; i < 3; i++) {
                System.out.printf("%s -> %d\n", Thread.currentThread().getName(), res.x);
                res.x++;
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

