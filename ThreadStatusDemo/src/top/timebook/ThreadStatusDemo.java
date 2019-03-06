package top.timebook;

import java.io.IOException;

/**
 * 测试线程状态
 * 
 * @author xiongzl
 */
public class ThreadStatusDemo {

	public static void main(String[] args) {
		boolean flag = false;
		if (flag) {
			// 测试线程runnable状态
			testThreadRunnableStatus();

			// 测试线程Blocked状态
			testThreadBlockedStatus();
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 测试线程waiting状态
		testThreadWaitingStatus();

	}

	/**
	 * @Title: testThreadWaitingStatus
	 * @Description: 测试线程waiting状态
	 * @return: void
	 * @author: xiongzl
	 * @date: 2019年3月7日
	 */
	private static void testThreadWaitingStatus() {
		Object obj = new Object();
		new Thread(() -> {
			synchronized (obj) {
				try {
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	/**
	 * @Title: testThreadBlockedStatus
	 * @Description: 测试线程Blocked状态
	 * @return: void
	 * @author: xiongzl
	 * @date: 2019年3月7日
	 */
	private static void testThreadBlockedStatus() {
		Object obj = new Object();

		// timed_waiting 状态
		new Thread(() -> {
			synchronized (obj) {
				try {
					Thread.sleep(1000000000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		// blocked状态
		new Thread(() -> {
			synchronized (obj) {

			}
		}).start();

	}

	/**
	 * @Title: testThreadRunnableStatus
	 * @Description: 测试线程runnable状态, 状态可以通过jconsole查看.
	 * @return: void
	 * @author: xiongzl
	 * @date: 2019年3月6日
	 */
	private static void testThreadRunnableStatus() {
		Thread thread = new Thread(() -> {
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		thread.start();
	}

}
