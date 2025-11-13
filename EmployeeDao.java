package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.entity.Employee;

public class EmployeeDao {
	
	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager entityManager = null;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("rohit");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public static void addNewEmployee(Employee employee){
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	
	public static Employee getEmpById(int id) {
		return entityManager.find(Employee.class, id);
	}
	
	public static void updateEmp(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
	}
	public static void deleteDept(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
	}

}