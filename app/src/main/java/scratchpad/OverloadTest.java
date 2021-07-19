package scratchpad;

@SuppressWarnings("CommentedOutCode")
public class OverloadTest {

    public void test(int a) {
        System.out.println("a = " + a);
    }

    public void test(int a, int b) {
        System.out.println("a = " + a + ", b = " + b);
    }

    public void test(int a, double b) {
        System.out.println("a = " + a + ", b = " + b);
    }

    public void test(int a, double b, long c) {
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
    }

//    compile error.
//    public void test(String d) {
//    }

    @SuppressWarnings("UnusedReturnValue")
    public String test(String d) {
        System.out.println("d = " + d);
        return "test";
    }

    public static void main(String[] args) {
        OverloadTest test = new OverloadTest();
        test.test(1); //  a = 1
        test.test(1, 2); // a = 1, b = 2
        test.test(1, 2.0); // a = 1, b = 2.0
        test.test(1, 2.0, 3); // a = 1, b = 2.0, c = 3
        test.test("test"); // d = test
    }
}
