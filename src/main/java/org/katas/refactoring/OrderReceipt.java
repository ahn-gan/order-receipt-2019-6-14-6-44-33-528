package org.katas.refactoring;

import java.util.List;

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
        double totalSalesTax = getTotalSalesTax(order.getLineItems());
        double totalAmount = getTotalAmount(order.getLineItems());
        return getPrintString(totalSalesTax, totalAmount);
    }

    private String getPrintString(double totalSalesTax, double totalAmount) {
        StringBuilder output = new StringBuilder();
        output.append(HEADERS + order.getCustomerName() + order.getCustomerAddress());
        // prints lineItems
        for (LineItem lineItem : order.getLineItems()) {
            output.append(String.format(ITEM_DETAIL_TEMPLATE, lineItem.getDescription(), lineItem.getPrice(), lineItem.getQuantity(), lineItem.calculateTotalAmount()));
        }
        output.append(String.format(SALES_TAX_AND_TOTAL_AMOUNT_TEMPLATE, totalSalesTax, totalAmount));
        return output.toString();
    }

    private double getTotalSalesTax(List<LineItem> lineItems) {
        return (lineItems.stream().mapToDouble(LineItem::calculateTotalAmount).sum()) * SALES_TAX_RATE;
    }

    private double getTotalAmount(List<LineItem> lineItems) {
        // calculate total amount of lineItem = price * quantity + 10 % sales tax
        return lineItems.stream().mapToDouble(LineItem::calculateTotalAmount).sum() * (1 + SALES_TAX_RATE);

    }
}