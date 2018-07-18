package test.junjie.concurrent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Random> queue = null;

	public Producer(BlockingQueue<Random> queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			Random a = new Random();
			if (queue.offer(a)) {
				System.out.println("offer success " + a.toString());
			} else {
				break;
			}
		}
	}

}
