package test.junjie.concurrent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
	private BlockingQueue<Random> queue = null;

	public Consumer(BlockingQueue<Random> queue) {
		this.queue = queue;
	}

	public void run() {
		boolean flag = true;
		while (flag) {
			Random a;
			try {
				a = queue.poll(2, TimeUnit.SECONDS);
				if (a == null) {
					System.out.println("poll failed");
					break;
				} else {
					System.out.println("poll success " + a.toString());
				}
			} catch (InterruptedException e) {
				break;
			}

		}
	}

}
