package scratchpad;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class MemoryLayoutTest {
    static volatile Object consumer;

    public static void main(String[] args) {
//        VM details
        System.out.println(VM.current().details());

//        Basic memory layout example
        System.out.println(ClassLayout.parseClass(SimpleInt.class).toPrintable());

//        Identity Hash Code
        SimpleInt simpleInt = new SimpleInt();
        System.out.println("Identity hashcode is:");
        System.identityHashCode(simpleInt);
        System.out.println(ClassLayout.parseInstance(simpleInt).toPrintable());

//        Alignment
        System.out.println(ClassLayout.parseClass(SimpleLong.class).toPrintable());

//        Field Packing
        System.out.println(ClassLayout.parseClass(FieldsArrangement.class).toPrintable());

//        Locking
        Lock lock = new Lock();
        synchronized (lock) {
            System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        }

//        Age and Tenuring
        Object instance = new Object();
        long lastAddr = VM.current().addressOf(instance);
        ClassLayout layout = ClassLayout.parseInstance(instance);

        for (int i = 0; i < 10_000; i++) {
            long currentAddr = VM.current().addressOf(instance);
            if (currentAddr != lastAddr) {
                System.out.println(layout.toPrintable());
            }

            for (int j = 0; j < 10_000; j++) {
                consumer = new Object();
            }

            lastAddr = currentAddr;
        }

    }
}

class SimpleInt {
    private int state;
}

class SimpleLong {
    private long state;
}

class FieldsArrangement {
    private boolean first;
    private char second;
    private double third;
    private int fourth;
    private boolean fifth;
}

class Lock {
}