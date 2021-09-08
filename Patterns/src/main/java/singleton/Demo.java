package singleton;

public class Demo {
    public static void main(String[] args) {
        Thread threadFirst = new Thread(new ThreadFirst());
        Thread threadSecond = new Thread(new ThreadSecond());
        threadFirst.start();
        threadSecond.start();
    }

    static class ThreadFirst implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FIRST");
            System.out.println(singleton.value);
        }
    }

    static class ThreadSecond implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("SECOND");
            System.out.println(singleton.value);
        }
    }
}
