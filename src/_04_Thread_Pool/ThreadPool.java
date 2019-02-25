package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	private Thread[] threads;
	private ConcurrentLinkedQueue<Task> taskQueue;
	
	public ThreadPool(int totalThreads) {
		threads = new Thread[totalThreads];
		for (Thread t : threads) {
			
		}
	}
}
