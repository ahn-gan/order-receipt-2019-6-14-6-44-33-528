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

        // print date, bill no,
//        output.append("Date - " + order.getDate();

//        output.append(order.getCustomerName());
//        output.append(order.getCustomerAddress());

//        output.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        double totalSalesTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {

            output.append(String.format(ITEM_DETAIL_TEMPLATE, lineItem.getDescription(), lineItem.getPrice(), lineItem.getQuantity(), lineItem.totalAmount()));

//            output.append(lineItem.getDescription());
//            output.append('\t');
//            output.append(lineItem.getPrice());
//            output.append('\t');
//            output.append(lineItem.getQuantity());
//            output.append('\t');
//            output.append(lineItem.totalAmount());
//            output.append('\n');

            // calculate sales tax @ rate of 10%
//            double salesTax = lineItem.totalAmount() * SALES_TAX_RATE;
            totalSalesTax += lineItem.totalAmount() * SALES_TAX_RATE;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += lineItem.totalAmount() + lineItem.totalAmount() * SALES_TAX_RATE;
        }

        // prints the state tax

        output.append(String.format(SALES_TAX_AND_TOTAL_AMOUNT_TEMPLATE, totalSalesTax, totalAmount));
//        output.append(SALES_TAX).append('\t').append(totSalesTx);

        // print total amount

//        output.append(TOTAL_AMOUNT).append('\t').append(tot);
        return output.toString();
    }
}