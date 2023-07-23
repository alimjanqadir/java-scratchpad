package scratchpad;

public class PrivateClassTest {
	public static void main(String[] args) {
		var a = new A();
		System.out.println(a.toString());
	}
	private static class A{
		public A(){}
	}
}

//private class A{
//	public A(){}
//}

