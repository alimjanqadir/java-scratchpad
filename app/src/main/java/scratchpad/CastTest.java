package scratchpad;

class CastTest {
	public static <T> void main(String[] args) {
		Object i = 1;
		var string = (T) i;
	}
}
