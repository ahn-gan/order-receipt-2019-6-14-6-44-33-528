package org.katas.refactoring;

public class LineItem {
    private String description;
    private double p;
    private int qty;

    public LineItem(String description, double p, int qty) {
        super();
        this.description = description;
        this.p = p;
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return p;
    }

    public int getQuantity() {
        return qty;
    }

    double totalAmount() {
        return p * qty;
    }
}