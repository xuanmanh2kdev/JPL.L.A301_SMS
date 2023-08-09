package fa.training.dao;

import java.util.List;

import fa.training.entities.Customer;

public interface CustomerDAO {

	List<Customer> getAllCustomer();

	boolean addCustomer(Customer customer);

	boolean deleteCustomer(int customerId);

	boolean updateCustomer(Customer customer);
}
