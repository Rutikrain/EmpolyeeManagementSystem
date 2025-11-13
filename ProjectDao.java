package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.jsp.entity.Project;

public class ProjectDao {
	
	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager entityManager = null;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("rohit");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public static void addNewProject(Project project){
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(project);
		entityTransaction.commit();
	}
	
	public static Project getProjectById(int id) {
		return entityManager.find(Project.class, id);
	}
	
	public static void updatePro(Project project) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(project);
		entityTransaction.commit();
	}
	public static void deletePro(Project project) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(project);
		entityTransaction.commit();
	}

}