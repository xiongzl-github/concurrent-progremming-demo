package top.timebook;

/**
 * 使用lambda表达式创建线程
 * 
 * @author xiongzl
 *
 */
public class FourthWayOfBuildThread {

	public static void main(String[] args) {
		buildThread();
	}

	private static void buildThread() {
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
		}).start();
		
	}

}
