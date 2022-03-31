package synchronizes;

public class SynchronizedMethods {
    private int sum = 0;

    public void calculateWithoutSync(){
        sum++;
    }

    public synchronized void calculateWithSync(){
        sum++;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
