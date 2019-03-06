package top.timebook;

import java.util.concurrent.CountDownLatch;

/**
 * 测试线程安全性
 * 
 * @author xiongzl
 */
public class UnsafeThreadDemo {

	private static int num = 0;

	private static CountDownLatch cdl = new CountDownLatch(10);

	private static void addNum() {
		num++;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				for (int j = 0; j < 100; j++) {
					try {
						Thread.sleep(10L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					addNum();
				}
				cdl.countDown();
			}).start();
		}
		
		while(true) {
			if(cdl.getCount() == 0) {
				System.out.println("num: " + num + ".");
				break;
			}
		}
	}

}
