package fa.training.dao;

import static fa.training.common.SQLStatementConstant.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fa.training.common.DBUtils;
import fa.training.entities.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customers = new ArrayList<>();
		try (Connection conn = DBUtils.getConnection();) {
			Statement stm = conn.createStatement();

			ResultSet rs = stm.executeQuery(SELECT_ALL_CUSTOMER_HAS_PURCHASED);

			while (rs.next()) {
				customers.add(new Customer(rs.getInt("customer_id"), rs.getString("customer_name")));
			}
			return customers;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	@Override
	public boolean addCustomer(Customer customer) {

		try (Connection conn = DBUtils.getConnection();) {
			PreparedStatement stm = conn.prepareStatement(ADD_CUSTOMER);

			stm.setString(1, customer.getCustomerName());

			int rows = stm.executeUpdate();
			return rows == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		try (Connection conn = DBUtils.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(DELETE_CUSTOMER_BY_ID);
			statement.setInt(1, customerId);
			return statement.executeUpdate() >= 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {

		if (customer == null || customer.getCustomerId() == 0) {
			throw new IllegalArgumentException("Customer is invalid");
		}

		try (Connection conn = DBUtils.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(UPDATE_CUSTOMER);
			statement.setString(1, customer.getCustomerName());
			statement.setInt(2, customer.getCustomerId());

			int rowAffected = statement.executeUpdate();
			return rowAffected == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
