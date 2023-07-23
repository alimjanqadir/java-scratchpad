package scratchpad;

public class InnerClassInheritanceTest extends OuterClass.InnerClass{
//	 public InnerClassInheritanceTest() {}
	public InnerClassInheritanceTest(OuterClass outer) {
		outer.super();
	}
	public static void main(String[] args) {
	
	}
}

class OuterClass {
	class InnerClass{}
}
