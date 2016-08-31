package MultiThreading;

/**
 *
 * @author Plankton
 */
class meow implements Runnable {

    private Thread t;
    private String threadName;

    meow(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class TestThread {

    public static void main(String args[]) {

        meow m1 = new meow("Thread-1");
        m1.start();

        meow m2 = new meow("Thread-2");
        m2.start();
    }
}
