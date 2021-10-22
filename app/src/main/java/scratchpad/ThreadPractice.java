package scratchpad;

import java.util.stream.IntStream;

public final class ThreadPractice {
	public static void main(String[] args) {
		var practiceOne = new PracticeOne();
		practiceOne.run();
	}	
}

final class PracticeOne implements Runnable{
	public void run() {
		Runnable r1 = ()-> {
			for(int i = 0; i<50; i++) {
				System.out.println(String.format("%s: %d", Thread.currentThread().getName(), i));
				try {
					Thread.sleep(100);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		};	
		var t1 = new Thread(r1, "t1");
		t1.start();

		IntStream.range(0, 50).forEach(i->{
			if(i>10){
				try {
					t1.join();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(i);
		});
	}
} 
