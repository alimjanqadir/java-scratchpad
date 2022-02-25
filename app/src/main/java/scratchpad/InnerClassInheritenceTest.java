public class InnerClassInheritenceTest extends OuterClass.InnerClass{
//	 public InnerClassInheritenceTest() {}
	public InnerClassInheritenceTest(OuterClass outer) {
		outer.super();
	}
	public static void main(String[] args) {
	
	}
}

class OuterClass {
	class InnerClass{}
}
