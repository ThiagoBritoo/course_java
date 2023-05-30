package entities;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("(dd/MM/yyyy)");
	private static DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private LocalDateTime moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);		
	}
	public void removeItem(OrderItem item) {
		items.remove(item);		
	}
	
	public Double total() {
		double sum = 0;
		for (OrderItem i : items) {
			sum = sum + i.getProduct().getPrice() * i.getQuantity();
		} return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nORDER SUMMARY:\n");
		sb.append("Order moment: " + moment.format(fmt2)); 
		sb.append("\nOrder Status: " + status);
		sb.append("\nClient: " + client.getName() + " " + client.getBirthDate().format(fmt1) + " - " + client.getEmail()); 
		sb.append("\nOrder items:");

		for (OrderItem i : items) {
			sb.append("\n" + i.getProduct().getName() + ", $" + String.format("%.2f", i.getProduct().getPrice()) 
			+ ", Quantity: " + i.getQuantity() 
			+ ", Subtotal: $" + String.format("%.2f", i.subTotal()));
		}		
		sb.append("\nTotal Price: $" + String.format("%.2f", total()));
		return sb.toString();
	} 
}
