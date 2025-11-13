package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.entity.Department;

public class DepartmentDao {
	
	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager entityManager = null;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("rohit");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public static void addNewDepartment(Department department){
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(department);
		entityTransaction.commit();
	}

	public static Department getDeptById(int id) {
		return entityManager.find(Department.class, id);
	}
	
	public static void updateDept(Department department) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(department);
		entityTransaction.commit();
	}
	public static void deleteDept(Department department) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(department);
		entityTransaction.commit();
	}
}