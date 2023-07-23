package scratchpad;

import java.util.Random;

public final class ForInFloat {
	public static void main(String[] args) {
		Random random = new Random();
		float[] f = new float[10];
		for(int i=0; i<f.length; i++)
			f[i] = random.nextFloat();
		for(float n : f)
			System.out.println(n);	
	}
}
