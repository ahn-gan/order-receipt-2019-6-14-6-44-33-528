package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {

    private final String HEADERS = "======Printing Orders======\n";
    private final String SALES_TAX = "Sales Tax";
    private final String TOTAL_AMOUNT = "Total Amount";
    private final String SALES_TAX_AND_TOTAL_AMOUNT_TEMPLATE = SALES_TAX + "\t%s" + TOTAL_AMOUNT + "\t%s";
    private final String ITEM_DETAIL_TEMPLATE = "%s\t%s\t%s\t%s\n";
    private final double SALES_TAX_RATE = 0.10;

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers,customer name and address
        output.append(HEADERS + order.getCustomerName() + order.getCustomerAddress());

        // prints lineItems
        double totalSalesTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(String.format(ITEM_DETAIL_TEMPLATE, lineItem.getDescription(), lineItem.getPrice(), lineItem.getQuantity(), lineItem.totalAmount()));
            totalSalesTax = getTotalSalesTax(totalSalesTax, lineItem);

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount = getTotalAmount(totalAmount, lineItem);
        }
        output.append(String.format(SALES_TAX_AND_TOTAL_AMOUNT_TEMPLATE, totalSalesTax, totalAmount));
        return output.toString();
    }

    private double getTotalSalesTax(double totalSalesTax, LineItem lineItem) {
        totalSalesTax += lineItem.totalAmount() * SALES_TAX_RATE;
        return totalSalesTax;
    }

    private double getTotalAmount(double totalAmount, LineItem lineItem) {
        totalAmount += lineItem.totalAmount() + lineItem.totalAmount() * SALES_TAX_RATE;
        return totalAmount;
    }
}