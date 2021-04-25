package scratchpad;

class NotSynchronizedThread implements Runnable {
    private int ticket = 5;
    final Object lock = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
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


public class NotSynchronizedThreadTest {
    public static void main(String[] args) {
        Runnable notSynchronizedThread = new NotSynchronizedThread();
        Thread thread1 = new Thread(notSynchronizedThread);
        Thread thread2 = new Thread(notSynchronizedThread);
        Thread thread3 = new Thread(notSynchronizedThread);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
