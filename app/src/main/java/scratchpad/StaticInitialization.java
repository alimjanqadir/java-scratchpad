package scratchpad;

public class StaticInitialization {
	class InnerClassA {
		InnerClassA() {
			System.out.println("innerclass a");
		}
	}

	static class InnerClassB {
		InnerClassB() {
			System.out.println("innerclass b");
		}
	}
	
	static InnerClassB classB = new InnerClassB(); 
	InnerClassA aClass = new InnerClassA();
	//StaticInitialization staticInit = new StaticInitialization();
	public static void main(String[] args) {
		new StaticInitialization();
		for(String arg : args)
			System.out.print(" " + arg);
		System.out.print("\n");
	}
}
