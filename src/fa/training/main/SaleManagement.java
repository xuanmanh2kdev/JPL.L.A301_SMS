package fa.training.main;

import java.util.List;
import java.util.Scanner;

import fa.training.dao.*;
import fa.training.entities.Customer;
import fa.training.entities.LineItem;
import fa.training.entities.Order;

public class SaleManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OrderDAO orderDAO = new OrderDAOImpl();
		CustomerDAO customerDAO = new CustomerDAOImpl();
		LineItemDAO lineItemDAO = new LineItemDAOImpl();
		int choice = 0;

		do {
			System.out.println("Choose function:");
			System.out.println("1. Get all customers");
			System.out.println("2. Get all orders by customer id");
			System.out.println("3. Get all items by order id");
			System.out.println("4. Compute order total");
			System.out.println("5. Add customer");
			System.out.println("6. Delete customer");
			System.out.println("7. Update customer");
			System.out.println("8. Add order");
			System.out.println("9. Add line item");
			System.out.println("10. Update order total");
			System.out.println("11. Exit");

			sc = new Scanner(System.in);
			choice = sc.nextInt();

			switch (choice) {
			case 1 -> {
				System.out.println();
				System.out.println("--------- List all customers in the database ---------");
				List<Customer> customerList = customerDAO.getAllCustomer();
				customerList.forEach(System.out::println);
				System.out.println();
			}
			case 2 -> {
				System.out.print("Enter customer ID: ");
				int customerId = sc.nextInt();

				System.out.println();
				System.out.println("--------- List all orders by customer id in the database ---------");
				orderDAO.getAllOrdersByCustomerId(customerId).forEach(System.out::println);
				System.out.println();
			}
			case 3 -> {
				System.out.println("--------- List all items ---------");

				System.out.print("Enter order ID: ");
				int orderId = sc.nextInt();

				System.out.println();
				orderDAO.getAllItemsByOrderId(orderId).forEach(System.out::println);
				System.out.println();
			}
			case 4 -> {
				System.out.println("--------- Compute order total ---------");

				System.out.print("Enter order ID: ");
				int orderId = sc.nextInt();

				System.out.println();
				System.out.println(orderDAO.computeOrderTotal(orderId));
				System.out.println();
			}
			case 5 -> {
				System.out.println("--------- Insert a customer ---------");

				System.out.print("Enter name: ");
				sc = new Scanner(System.in);
				String customerName = sc.nextLine();
				Customer customer = new Customer(customerName);
				customerDAO.addCustomer(customer);
				System.out.println("--------- Insert success ---------");
			}
			case 6 -> {
				System.out.println("--------- Delete a customer ---------");

				System.out.println("Enter customer ID: ");
				int customerId = sc.nextInt();

				System.out.println("Delete customer: " + customerDAO.deleteCustomer(customerId));
			}
			case 7 -> {
				System.out.println("--------- Update a customer ---------");
				System.out.print("Enter the id customer you want to update : ");
				int customerID = sc.nextInt();

				sc = new Scanner(System.in);
				System.out.print("Enter the name customer you want to update : ");
				String customerName = sc.nextLine();

				Customer customer = new Customer(customerID, customerName);
				customerDAO.updateCustomer(customer);

				System.out.println("--------- Update success ---------");
			}
			case 8 -> {
				System.out.println("--------- Insert a order ---------");

				System.out.print("Enter customer ID: ");
				int customerID = sc.nextInt();

				System.out.print("Enter employee ID: ");
				int employeeID = sc.nextInt();

				System.out.print("Enter total: ");
				int total = sc.nextInt();

				orderDAO.addOrder(new Order(customerID, employeeID, total));

				System.out.println("--------- Insert success ---------");
			}
			case 9 -> {
				System.out.println("--------- Insert an order ---------");

				System.out.print("Enter order id: ");
				sc = new Scanner(System.in);
				int orderId = sc.nextInt();

				System.out.print("Enter product id: ");
				int productId = sc.nextInt();

				System.out.print("Enter quantity: ");
				int quantity = sc.nextInt();

				System.out.print("Enter price: ");
				int price = sc.nextInt();

				lineItemDAO.addLineItem(new LineItem(orderId, productId, quantity, price));

				System.out.println("--------- Insert success ---------");
			}
			case 10 -> System.out.println("Update total: " + orderDAO.updateOrderTotal(6));
			default -> choice = 11;
			}
		} while (choice != 11);

	}
}
