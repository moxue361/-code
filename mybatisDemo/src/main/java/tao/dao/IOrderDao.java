package tao.dao;

import java.util.List;
import tao.bean.Order;

public interface IOrderDao {
    public List<Order> findAll();
}