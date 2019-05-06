package com.tallinn.six.recap.Task15;

import java.math.BigDecimal;

public class AuctionedItem {
    private String name;
    private BigDecimal price;

    public AuctionedItem(String name, String price) {
        this.name = name;
        this.price = new BigDecimal(price).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
