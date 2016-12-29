/**
 * 
 */
package com.avasojo.avasojoSynchronized;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * @author Avasojo
 *
 */
public class AvasojoSyncClassRequested {

	/**
	 * @author avasojo.com
	 *
	 */

	public final static int THREAD_POOL_SIZE = 5;
	public static AvasojoSyncClassRequested theACRS = null;
	
	public static AvasojoSyncClassRequested getSyncContainer(Map<String, Integer> hmObj) {
		if (theACRS==null) {
			try {
				theACRS = new AvasojoSyncClassRequested(hmObj);
			} catch (InterruptedException e) {
				System.out.println("Sync Class threw anIntterruptedException, please review logs!!!!!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
			}
		}
		return theACRS;
	}

	public AvasojoSyncClassRequested(final Map<String, Integer> avasojoThreads) throws InterruptedException {

		System.out.println("Test started for: " + avasojoThreads.getClass());
		long averageTime = 0;
		for (int i = 0; i < 5; i++) {

			long startTime = System.nanoTime();
			ExecutorService avasojoExServer = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

			for (int j = 0; j < THREAD_POOL_SIZE; j++) {
				avasojoExServer.execute(new Runnable() {
					@SuppressWarnings("unused")
					@Override
					public void run() {

						for (int i = 0; i < 500000; i++) {
							Integer avasojoRandomNumber = (int) Math.ceil(Math.random() * 550000);

							// Retrieve value. We are not using it anywhere
							Integer avasojoValue = avasojoThreads.get(String.valueOf(avasojoRandomNumber));

							// Put value
							avasojoThreads.put(String.valueOf(avasojoRandomNumber), avasojoRandomNumber);
						}
					}
				});
			}

			// Make sure executor stops
			avasojoExServer.shutdown();

			// Blocks until all tasks have completed execution after a shutdown
			// request
			avasojoExServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

			long entTime = System.nanoTime();
			long totalTime = (entTime - startTime) / 1000000L;
			averageTime += totalTime;
			System.out.println("2500K entried added/retrieved in " + totalTime + " ms");
		}
		System.out.println("For " + avasojoThreads.getClass() + " the average time is " + averageTime / 5 + " ms\n");
		return;
	}
}
