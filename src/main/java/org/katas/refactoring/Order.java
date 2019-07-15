package org.katas.refactoring;

import java.util.List;

public class Order {
    String name;
    String addr;
    List<LineItem> li;

    public Order(String name, String addr, List<LineItem> li) {
        this.name = name;
        this.addr = addr;
        this.li = li;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return li;
    }
}
