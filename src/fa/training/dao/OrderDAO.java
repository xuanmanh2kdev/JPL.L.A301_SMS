package fa.training.dao;

import java.util.List;

import fa.training.entities.LineItem;
import fa.training.entities.Order;

public interface OrderDAO {

	List<Order> getAllOrdersByCustomerId(int customerId);

	Double computeOrderTotal(int orderId);

	boolean addOrder(Order order);

	boolean updateOrderTotal(int orderId);

	List<LineItem> getAllItemsByOrderId(int orderId);

}
