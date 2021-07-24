package scratchpad;

import java.io.*;

public class ObjectOutputStreamTest {
    public static void main(String[] args) {
        final InnerClass innerClass = new InnerClass();
        try {
            OutputStream outputStream = new FileOutputStream("object.data");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(innerClass);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class InnerClass implements Serializable{
    public int publicInteger = 0;
    private int privateInteger = 0;

    public void test() {

    }
}
