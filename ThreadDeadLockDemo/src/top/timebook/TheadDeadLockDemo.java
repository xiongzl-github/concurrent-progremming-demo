package top.timebook;

public class TheadDeadLockDemo {

	public static final Object t1 = new Object();

	public static final Object t2 = new Object();

	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (t1) {
				try {
					Thread.sleep(50L);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (t2) {
					System.out.println("t1 抢先拿到了t2的锁!");
				}
			}
		}).start();

		new Thread(() -> {
			synchronized (t2) {
				synchronized (t1) {
					System.out.println("t2抢先拿到了t1的锁!");
				}
			}
		}).start();
	}
}
