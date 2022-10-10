package unit03;

public class ExThread {
	static long startTime = 0;
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		
		Runnable r = new Thread2();
		Thread t2 = new Thread(r);
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		
//		for(int i=0; i<500; i++)
//			System.out.print(0);
//		for(int i=0; i<500; i++)
//			System.out.print(1);
		
		startTime = System.currentTimeMillis();
		
		try {
			t1.join();		// main thread가 t1의 작업이 끝날 때까지 기다림.
			t2.join();		// main thread가 t2의 작업이 끝날 때까지 기다림.
		} catch(InterruptedException e) { }
		
		System.out.print("\n소요시간:"+(System.currentTimeMillis() - startTime)+"ms");
	}

}

class Thread1 extends Thread {
	@Override
	public void run() {
//		for(int i=0; i<5; i++) {
//			System.out.println(getName());
//		}
		for(int i=0; i<300; i++) {
			System.out.print(0);
			for(int x=0; x<10000000; x++) ;
		}
	}
}

class Thread2 implements Runnable {
	public void run() {
//		for(int i=0; i<5; i++) {
//			System.out.println(Thread.currentThread().getName());
//		}
		for(int i=0; i<300; i++) {
			System.out.print(1);
			for(int x=0; x<10000000; x++) ;
		}
	}
}