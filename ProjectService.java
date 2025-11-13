package com.jsp.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.jsp.dao.ProjectDao;
import com.jsp.entity.Project;

public class ProjectService {
	static Scanner sc = new Scanner(System.in);

	public static void projectService() {

		System.out.println("Enter 1 To Add New Project : ");
		System.out.println("Enter 2 To Fetch The Details Of The Existing project : ");
		System.out.println("Enter 3 To Update The Existing project Details : ");
		System.out.println("Enter 4 To Delete The Existing project : ");
		int choice = sc.nextInt();
		System.out.println("---------------------------------------------------------------");
		if (choice == 1) {
			addNewProject();
		} else if (choice == 2) {
			getProjectId();
		}
		  else if (choice == 3) {
			updateProject();
		} else if (choice == 4) {
			deletePro();
		}

	}

	public static void addNewProject() {
		sc.nextLine();
		System.out.println("Enter The Project Name : ");
		String protitle = sc.nextLine();
		System.out.println("Project deadline details:");
		System.out.println("enter project deadline date");
		int date = sc.nextInt();
		System.out.println("enter deadline month");
		int month = sc.nextInt();
		System.out.println("enter deadline year");
		int year = sc.nextInt();

		Project project = new Project(protitle, LocalDate.of(year, month, date));
		ProjectDao.addNewProject(project);
	}

	public static void getProjectId() {
		System.out.println("Enter The Project Id Whose Details Needs To Be Fetched : ");
		int id = sc.nextInt();

		Project project = ProjectDao.getProjectById(id);
		if (project != null) {
			System.out.println("Project Details Are : ");
			System.out.println("Project Id Is : " + project.getId());
			System.out.println("Project Name Is : " + project.getTitle());
			System.out.println("Project Startdate Is : " + project.getStartdate());
			System.out.println("Project deadline Is : " + project.getDeadline());

		} else {
			System.out.println("Employee With Id " + id + " Does Not Exist");
		}
	}

	public static void updateProject() {
		System.out.println("Enter Project Id Whose details needs to be updated");
		int id = sc.nextInt();
		Project project = ProjectDao.getProjectById(id);
		if (project != null) {
			sc.nextLine();
			System.out.println("Enter The New Project Deadline: date ");
			int date = sc.nextInt();
			System.out.println("Enter The New Project Deadline: month");
			int month = sc.nextInt();
			System.out.println("Enter The New Project Deadline: year");
			int year = sc.nextInt();
			sc.nextLine();
			project.setDeadline(LocalDate.of(year, month, date));
			ProjectDao.updatePro(project);

		} else {
			System.out.println("Project With Id " + id + " Does Not Exist");
		}
	}

	public static void deletePro() {
		System.out.println("Enter Project Id Whose Details Needs To Be Deleted");
		int id = sc.nextInt();
		Project project = ProjectDao.getProjectById(id);
		if (project != null) {
			ProjectDao.deletePro(project);
		} else {
			System.out.println("Project With Id " + id + " Does Not Exist");
		}

	}

}