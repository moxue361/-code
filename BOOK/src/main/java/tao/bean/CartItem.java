package tao.bean;

import java.math.BigDecimal;

public class CartItem {
    private int id;
    private int count;
    private String name;
    private BigDecimal price;
    private BigDecimal totalPrice;

    public CartItem(int id, int count, String name, BigDecimal price, BigDecimal totalPrice) {
        this.id = id;
        this.count = count;
        this.name = name;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public CartItem() {
    }

    @Override
    public String toString() {
        return "CartItem [count=" + count + ", id=" + id + ", name=" + name + ", price=" + price + ", totalPrice="
                + totalPrice + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}