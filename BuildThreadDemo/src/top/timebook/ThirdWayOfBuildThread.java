package top.timebook;

/**
 * 使用匿名内部类的方式创建线程.
 * @author xiongzl
 *
 */
public class ThirdWayOfBuildThread {
	
	public static void main(String[] args) {
		buildThread();
	}

	private static void buildThread() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
		t.setName("t3");
		t.start();
	}
	
	
}
