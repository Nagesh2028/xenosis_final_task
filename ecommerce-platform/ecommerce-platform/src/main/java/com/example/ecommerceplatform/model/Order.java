package com.example.ecommerceplatform.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Order {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

	    private LocalDateTime orderDate;
	    private BigDecimal totalAmount;

	    @OneToMany(mappedBy = "order")
	    private Set<OrderItem> orderItems;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public LocalDateTime getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDateTime orderDate) {
			this.orderDate = orderDate;
		}

		public BigDecimal getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(BigDecimal totalAmount) {
			this.totalAmount = totalAmount;
		}

		public Set<OrderItem> getOrderItems() {
			return orderItems;
		}

		public void setOrderItems(Set<OrderItem> orderItems) {
			this.orderItems = orderItems;
		}
private String status;

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

	    

}
