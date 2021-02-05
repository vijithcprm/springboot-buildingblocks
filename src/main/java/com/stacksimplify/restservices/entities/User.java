package com.stacksimplify.restservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"firstname","lastname"})
public class User extends ResourceSupport {

	@Id
	@GeneratedValue
	private Long userId;

	@NotEmpty(message = "Username is Mandatory field. Please provide username")
	@Column(name = "user_name", length = 50, nullable = false, unique = true)
	private String username;

	@Size(min = 2, message = "FirstName should have atlease 2 characters")
	@Column(name = "first_name", length = 50, nullable = false)
	private String firstname;

	@Column(name = "last_name", length = 50, nullable = false)
	private String lastname;

	@Column(name = "email", length = 50, nullable = false)
	private String email;

	@Column(name = "role", length = 50, nullable = false)
	private String role;

	@Column(name = "ssn", length = 50, nullable = false, unique = true)
	@JsonIgnore
	private String ssn;

	@OneToMany(mappedBy = "user")
	private List<Order> orders;

	public User() {

	}

	public User(Long userId, String username, String firstname, String lastname, String email, String role, String ssn,
			List<Order> orders) {
		this.userId = userId;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = orders;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", orders=" + orders + "]";
	}

}
