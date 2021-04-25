package scratchpad;

class SynchronizedThread implements Runnable {
    private int ticket = 5;
    final Object lock = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (lock) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                    System.out.println("Ticket: " + ticket--);
                }
            }
        }
    }
}

public class SynchronizedThreadTest {
    public static void main(String[] args) {
        Runnable synchronizedThread = new SynchronizedThread();
        Thread thread1 = new Thread(synchronizedThread);
        Thread thread2 = new Thread(synchronizedThread);
        Thread thread3 = new Thread(synchronizedThread);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
