package fa.training.entities;

public class Customer {

	private int customerId;
	private String customerName;

	public Customer() {
		super();
		customerId = 0;
		customerName = null;
	}

	public Customer(String customerName) {
		this.customerName = customerName;
	}

	public Customer(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + "]";
	}

}
