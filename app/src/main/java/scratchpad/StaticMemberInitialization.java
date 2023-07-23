package scratchpad;

public class StaticMemberInitialization {
    public static void main(String[] args) {
        var test = new ClassThatHasStaticMember();
        //test.text();
    }
}

class ClassThatHasStaticMember {
    private static class InnerStaticClass {
        static String text = text();

        static String text() {
            System.out.println("InnerStaticClass text");
            return "text";
        }
    }

    static {
        System.out.println("static");
    }

    void text() {
        System.out.println(InnerStaticClass.text);
    }
}


