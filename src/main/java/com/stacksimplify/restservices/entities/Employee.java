package com.stacksimplify.restservices.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue
	@JsonView(EmployeeViews.NormalView.class)
	private Long empid;
	
	@JsonView(EmployeeViews.NormalView.class)
	private String name;
	
	@JsonView(EmployeeViews.NormalView.class)
	private String department;
	
	@JsonView(EmployeeViews.ManagerView.class)
	private Date loginTime;
	
	@JsonView(EmployeeViews.ManagerView.class)
	private Date logoutTime;
	
	@JsonView(EmployeeViews.HRView.class)
	private Double salary;
	
	@JsonView(EmployeeViews.HRView.class)
	private Date lastPromotionDate;
	

}
