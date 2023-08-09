package fa.training.dao;

import static fa.training.common.SQLStatementConstant.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import fa.training.entities.LineItem;
import fa.training.entities.Order;
import fa.training.common.DBUtils;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public List<Order> getAllOrdersByCustomerId(int customerId) {

		List<Order> orders = new ArrayList<>();

		try (Connection connection = DBUtils.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ORDER_BY_CUSTOMER_ID);
			statement.setInt(1, customerId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("order_id");
				Date orderDate = rs.getTimestamp("order_date");
				Double total = rs.getDouble("total");
				orders.add(new Order(id, orderDate, customerId, customerId, total));
			}
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public List<LineItem> getAllItemsByOrderId(int orderId) {

		List<LineItem> lineItems = new ArrayList<>();

		try (Connection connection = DBUtils.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ITEMS_BY_ORDER_ID);
			statement.setInt(1, orderId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int product_id = rs.getInt("product_id");
				int quantity = rs.getInt("quantity");
				Double price = rs.getDouble("price");
				lineItems.add(new LineItem(orderId, product_id, quantity, price));
			}
			return lineItems;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public Double computeOrderTotal(int orderId) {

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(SELECT_ORDER_TOTAL);
			statement.setInt(1, orderId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getDouble("total_price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addOrder(Order order) {

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(ADD_ORDER);
			statement.setInt(1, order.getCustomerId());
			statement.setInt(2, order.getEmployeeId());
			statement.setDouble(3, order.getTotal());
			statement.execute();

			int rowAffected = statement.executeUpdate();
			return rowAffected == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateOrderTotal(int orderId) {
		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(UPDATE_ORDER_TOTAL);
			statement.setInt(1, orderId);
			statement.setInt(2, orderId);
			int isUpdate = statement.executeUpdate();

			return isUpdate >= 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
