package janciepiela;

/**
 * 
 * @author Jan Ciepiela
 *
 */
public class Multithreading extends Thread {

	private int threadID;

	Multithreading(int threadID) {

		this.threadID = threadID;

	}

	/**
	 * Running the threads
	 */
	@Override
	public void run() {

		System.out.println("Running thread number: " + threadID);

		try {

			if (threadID == 1) {

				Main.pageOne("camera");

			}
			if (threadID == 2) {

				Main.pageTwo("camera");

			}
			if (threadID == 3) {

				Main.pageThree("camera");

			}
			if (threadID == 4) {

				Main.pageFour("camera");

			}
			if (threadID == 5) {

				Main.pageFive("camera");

			}

			sleep(1000);
		} catch (InterruptedException ex) {
			System.err.println(ex.getMessage());
		}
	}

}
