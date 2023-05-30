package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime moment = LocalDateTime.now();
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth Date (DD/MM/YYYY): ");
		LocalDate b_date = LocalDate.parse(sc.nextLine(), fmt1);
		
		Client c = new Client(name, email, b_date);
		
		System.out.println("\nEnter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		
		Order order = new Order(moment, status, c);
		
		System.out.print("How many items in this order? ");
		int q_items = sc.nextInt();
		
		for (int i = 1; i <= q_items; i++) {
			System.out.println("\nEnter item #" + i + " data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String p_name = sc.nextLine();
			
			System.out.print("Product price: ");
			double p_price = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int q_product = sc.nextInt();
			
			Product product = new Product(p_name, p_price);
			
			OrderItem item = new OrderItem(q_product, product);
			
			order.addItem(item);
		}
		
		System.out.println(order);
		
		
		sc.close();
	}

}
