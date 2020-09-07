package tao.bean;

import java.sql.Date;

public class Order {
    private int id;
    private Date Ordertime;
    private double total;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return Ordertime;
    }

    public void setOrdertime(Date ordertime) {
        Ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order [Ordertime=" + Ordertime + ", id=" + id + ", total=" + total + ", user=" + user + "]";
    }

    
}