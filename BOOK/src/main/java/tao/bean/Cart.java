package tao.bean;

import java.math.BigDecimal;
import java.util.List;

public class Cart {
    private int totalCount;
    private BigDecimal totalPrice;
    private List<CartItem> items;

    public Cart() {
    }

    public Cart(int totalCount, BigDecimal totalPrice, List<CartItem> items) {
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart [items=" + items + ", totalCount=" + totalCount + ", totalPrice=" + totalPrice + "]";
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
    
}