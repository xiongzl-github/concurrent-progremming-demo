package top.timebook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池创建线程
 * @author xiongzl
 *
 */
public class FifthWayOfBuildThread {

	public static void main(String[] args) {
		buildThread();
	}

	private static void buildThread() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(() -> {
			System.out.println(Thread.currentThread().getName());
		});
	}
	
}
