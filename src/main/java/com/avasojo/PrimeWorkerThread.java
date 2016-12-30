import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PrimeWorkerThread extends Thread {
    final public static long[] primes = new long[10000];
    JTextArea output = null;
    long MAX ;
    public static AtomicInteger totalCount = new AtomicInteger(); // static global count
    static {
        primes[0] = 2; // init 1st prime only 1 time
    };

    public PrimeWorkerThread(int endnum, JTextArea output) {
        this.MAX = endnum;
        this.output = output;
    }

    final static AtomicLong nextNumber = new AtomicLong(3L);

    public void run() {
        long myNumber;
        int count = 0; // non static local count
        while ((myNumber = nextNumber.getAndAdd(2L)) <= MAX) {
            if (prime(myNumber)) {
                primes[totalCount.incrementAndGet()] = myNumber; // note increment and get instead of get and increment
                output.append("**" + myNumber + "**"); // output each prime that is found
                count++;

            }
        }
    }

    public static boolean prime(final long n) {
        final long maxI = (long) Math.sqrt(n); // faster than calculation of i*i each time
        for (long i = 3; i <= maxI; i += 2)
            if (n%i==0) return false;
        return true;
    }
}