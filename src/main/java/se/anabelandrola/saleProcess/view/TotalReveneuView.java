package main.java.se.anabelandrola.saleProcess.view;

import java.text.DecimalFormat;

import main.java.se.anabelandrola.saleProcess.model.TotalRevenueObserver;

/**
 * Shows amount paid for the sale.
 */
public class TotalReveneuView implements TotalRevenueObserver {

	private double amountPaid;

	/**
	 * Creates a new instance, with the amount paid set to zero.
	 */
	protected TotalReveneuView() {
		amountPaid = 0;
	}

	/**
	 * Invoked when a sale has been paid.
	 *
	 * @param amountPaid The total amount paid for the sale.
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
		System.out.println("Total reveneu is: " + format.format(amountPaid));
	}

}
