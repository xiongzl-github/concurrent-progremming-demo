package top.timebook;

/**
 * 通过继承Thread类, 实现创建线程. 
 * @author xiongzl
 */
public class FirstWayOfBuildThread extends Thread{

	public static void main(String[] args) {
		buildThread();
	}

	private static void buildThread() {
		FirstWayOfBuildThread t1 = new FirstWayOfBuildThread();
		t1.setName("t1");
		t1.start();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
	
	
	
	
}
