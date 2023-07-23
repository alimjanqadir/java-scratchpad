package scratchpad;

public final class SimpleThreadCreationExperiment {
    public static void main(String[] args) {
        //	var t1 = new TestThread();
        //	var t2 = new TestThread();
        //	var t3 = new TestThread();
        //	t1.start();t2.start();t3.start();
        Runnable r = () -> {
            for (int i = 0; i < 10; i++)
                System.out.println(i);
        };

        var t1 = new Thread(r);
        var t2 = new Thread(r);
        var t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
    }
}

final class TestThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println(i);
    }
}
