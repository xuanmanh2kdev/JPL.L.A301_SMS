package fa.training.entities;

import java.util.Date;

public class Order {

	private int orderId;
	private Date orderDate;
	private int customerId;
	private int employeeId;
	private double total;

	public Order() {
		super();
		orderId = 0;
		orderDate = null;
		customerId = 0;
		employeeId = 0;
		total = 0.0;
	}

	public Order(int customerId, int employeeId, double total) {
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.total = total;
	}

	public Order(int orderId, Date orderDate, int customerId, int employeeId, double total) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.total = total;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId + ", employeeId="
				+ employeeId + ", total=" + total + "]";
	}

}
