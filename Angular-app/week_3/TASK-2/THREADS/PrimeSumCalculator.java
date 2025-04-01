class PrimeSumThread extends Thread {
    private final int start, end;
    private long sum = 0;
    
    public PrimeSumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) sum += i;
        }
    }
    
    public long getSum() {
        return sum;
    }
}

public class PrimeSumCalculator {
    public static void main(String[] args) throws InterruptedException {
        int limit = 100;
        PrimeSumThread t1 = new PrimeSumThread(1, limit / 2);
        PrimeSumThread t2 = new PrimeSumThread(limit / 2 + 1, limit);
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println("Sum of prime numbers: " + (t1.getSum() + t2.getSum()));
    }
}