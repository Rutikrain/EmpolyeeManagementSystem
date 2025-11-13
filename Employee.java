package com.jsp.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "emp")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empId")
	private int id;
	@Column(name = "empName")
	private String name;
	@Column(name = "empPhone")
	private long phone;
	@Column(name = "empEmail")
	private String email;
	@CreationTimestamp
	private LocalDate dateofjoining;
	@ManyToOne
	@JoinColumn
	private Department department;
	@OneToOne(mappedBy = "employee" , cascade = {CascadeType.PERSIST , CascadeType.REMOVE})
	private Address address;
	@ManyToMany(mappedBy = "employees" , fetch = FetchType.EAGER)
	private List<Project> projects;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDateofjoining() {
		return dateofjoining;
	}
	public void setDateofjoining(LocalDate dateofjoining) {
		this.dateofjoining = dateofjoining;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, long phone, String email, LocalDate dateofjoining, Address address) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.dateofjoining = dateofjoining;
		this.address = address;
	}
	public Employee(String name, long phone, String email, LocalDate dateofjoining, Department department,
			Address address) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.dateofjoining = dateofjoining;
		this.department = department;
		this.address = address;
	}
	public Employee(String name, long phone, String email, LocalDate dateofjoining, Department department,
			Address address, List<Project> projects) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.dateofjoining = dateofjoining;
		this.department = department;
		this.address = address;
		this.projects = projects;
	}
	public Employee(String name, long phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
}