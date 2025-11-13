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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity 

public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projectId")
	private int id;
	@Column(name = "projectTitle")
	private String title;
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDate startdate;
	@Column(updatable=true , nullable = false)
	private LocalDate deadline;
	@ManyToMany(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
	@JoinTable(joinColumns = @JoinColumn , inverseJoinColumns = @JoinColumn)
	private List<Employee> employees;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(String title, LocalDate startdate, LocalDate deadline) {
		super();
		this.title = title;
		this.startdate = startdate;
		this.deadline = deadline;
	}
	public Project(String title, LocalDate startdate, LocalDate deadline, List<Employee> employees) {
		super();
		this.title = title;
		this.startdate = startdate;
		this.deadline = deadline;
		this.employees = employees;
	}
	public Project(String title, LocalDate deadline) {
		super();
		this.title = title;
		this.deadline = deadline;
	}
	
}
