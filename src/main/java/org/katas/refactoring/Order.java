package org.katas.refactoring;

import java.util.List;

public class Order {
    String name;
    
    String address;
    List<LineItem> li;

    public Order(String name, String address, List<LineItem> li) {
        this.name = name;
        this.address = address;
        this.li = li;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return li;
    }
}
