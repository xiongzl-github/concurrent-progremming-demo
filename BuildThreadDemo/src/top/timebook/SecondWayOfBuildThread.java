package top.timebook;

/**
 * 通过继承Runnable接口, 实现创建线程.
 * 
 * @author xiongzl
 *
 */
public class SecondWayOfBuildThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		buildThread();
	}

	private static void buildThread() {
		Thread t2 = new Thread(new SecondWayOfBuildThread(), "t2");
		t2.start();
	}
	
	

}
