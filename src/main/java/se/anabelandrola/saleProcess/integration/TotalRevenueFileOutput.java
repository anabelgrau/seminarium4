package main.java.se.anabelandrola.saleProcess.integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import main.java.se.anabelandrola.saleProcess.model.TotalRevenueObserver;

/**
 * Shows amount paid for the sale in a file.
 */

public class TotalRevenueFileOutput implements TotalRevenueObserver {
	private static final String LOG_FILE_NAME = "C://Users/Anabel Grau/eclipse-workspace/seminarium3/log/totalRevenueFile.txt";
	private PrintWriter logFile;
	private double amountPaid;

	/**
	 * Creates a new instance, with the amount paid set to zero.
	 */
	public TotalRevenueFileOutput() throws IOException {
		logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
		amountPaid = 0;
	}

	/**
	 * Add total revenue and print i file.
	 */
	@Override
	public void addTotalRevenue(double amount) {
		addTotalAmountPaid(amount);
		printPresentAmountPaid();
	}

	private void addTotalAmountPaid(double amount) {
		amountPaid += amount;
	}

	private void printPresentAmountPaid() {
		DecimalFormat format = new DecimalFormat("#.##");
		StringBuilder logMessageBuilder = new StringBuilder();
		logMessageBuilder.append("Total revenue is:");
		logMessageBuilder.append(format.format(amountPaid));
		logFile.println(logMessageBuilder);
	}

}
