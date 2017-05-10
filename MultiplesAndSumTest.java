import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class MultiplesAndSumTest {
	public static void main(String[] args) {
		CloseScannerSchedule();

		MultiplesAndSumOfOne(InputBelowData(), InputMultiplesOfOneData());
		//		MultiplesAndSumOfOne (10,3);     	 									// Find multiples of 3 which are below 10
		//		MultiplesAndSumOfOne (10,5);    	 									// Find multiples of 5 which are below 10
		//		MultiplesAndSumOfTwo (10,3,5);      									// Find multiples of 3 and 5 which are below 10
		MultiplesAndSumOfTwo(1000, 3, 5); // Find multiples of 3 and 5 which are below 1000
	}

	final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	private static void CloseScannerSchedule() {
		scheduler.schedule(new Runnable() {
			public void run() {
				System.out.println("Minal czas oczekiwania.");
				inputBelow.close();
				inputMultiplesOf.close();
				System.exit(0);
			}
		}, 60, SECONDS);
	}

	public static long below, multiplesOf;
	static Scanner inputBelow, inputMultiplesOf = null;

	private static long InputBelowData() {
		System.out.println("Podaj granice dla szukanych wielokrotnosci: ");
		inputBelow = new Scanner(System.in);
		below = inputBelow.nextLong();
		return below;
	}

	private static long InputMultiplesOfOneData() {
		System.out.println("Podaj liczbe, ktorej wielokrotnosci szukasz: ");
		inputMultiplesOf = new Scanner(System.in);
		multiplesOf = inputMultiplesOf.nextLong();
		return multiplesOf;
	}

	private static void MultiplesAndSumOfOne(long below, long multiplesOf) {
		long sum = 0; // Our sum variable, begins with 0

		for (int i = 1; i < below; i++) // Numbers we are checking up until it hits value of 'below'
		{
			if (i % multiplesOf == 0) {
				//				System.out.println( "Natural number below " + below + " that is multiple of " + multiplesOf + " : " + i + ".");
				sum = sum + i;
			}
		}

		System.out.println("Sum of the multiples of " + multiplesOf + " below " + below + " is " + sum + ".");
		System.exit(0);
	}

	private static void MultiplesAndSumOfTwo(long below, long multiplesOf1, long multiplesOf2) {
		long sum = 0; // Our sum variable, begins with 0

		for (int i = 1; i < below; i++) // Numbers we are checking up until it hits value of below
		{
			if (i % multiplesOf1 == 0 || i % multiplesOf2 == 0) {
				//				System.out.println( "Natural number below " + below + " that is multiple of " + multiplesOf1 + " or " + multiplesOf2 + ": " + i + ".");
				sum = sum + i;
			}
		}

		System.out.println("Sum of the multiples of " + multiplesOf1 + " or " + multiplesOf2 + " below " + below
				+ " is " + sum + ".");
		System.exit(0);
	}
}
