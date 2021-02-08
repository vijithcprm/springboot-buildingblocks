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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "user")
//@JsonIgnoreProperties({"firstname","lastname"}) ---Static filtering json
//@JsonFilter(value = "userFilter") -- used for MappingJacksonValue filtering section
public class User extends ResourceSupport {

	@Id
	@GeneratedValue
	@JsonView(Views.Externel.class)
	private Long userId;

	@NotEmpty(message = "Username is Mandatory field. Please provide username")
	@Column(name = "user_name", length = 50, nullable = false, unique = true)
	@JsonView(Views.Externel.class)
	private String username;

	@Size(min = 2, message = "FirstName should have atlease 2 characters")
	@Column(name = "first_name", length = 50, nullable = false)
	@JsonView(Views.Externel.class)
	private String firstname;

	@Column(name = "last_name", length = 50, nullable = false)
	@JsonView(Views.Externel.class)
	private String lastname;

	@Column(name = "email", length = 50, nullable = false)
	@JsonView(Views.Externel.class)
	private String email;

	@Column(name = "role", length = 50, nullable = false)
	@JsonView(Views.Internel.class)
	private String role;

	@Column(name = "ssn", length = 50, nullable = false, unique = true)
	// @JsonIgnore -- static filtering
	@JsonView(Views.Internel.class)
	private String ssn;

	@OneToMany(mappedBy = "user")
	@JsonView(Views.Internel.class)
	private List<Order> orders;
	
	private String address;

	public User() {

	}

	
	public User(Long userId,
			@NotEmpty(message = "Username is Mandatory field. Please provide username") String username,
			@Size(min = 2, message = "FirstName should have atlease 2 characters") String firstname, String lastname,
			String email, String role, String ssn, List<Order> orders, String address) {
		super();
		this.userId = userId;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = orders;
		this.address = address;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", orders=" + orders
				+ ", address=" + address + "]";
	}

	
}
