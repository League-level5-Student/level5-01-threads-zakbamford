package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	private Thread[] threads;
	private ConcurrentLinkedQueue<Task> taskQueue;
	
	public ThreadPool(int totalThreads) {
		threads = new Thread[totalThreads];
		taskQueue = new ConcurrentLinkedQueue<Task>();
		for (int i = 0; i < totalThreads; i++)
			threads[i] = new Thread(new Worker(taskQueue));
	}
	
	public void addTask(Task t) {
		taskQueue.add(t);
	}
	
	public void start() {
		for (Thread t : threads) {
			t.start();
			try {
				t.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
