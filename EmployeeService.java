package com.jsp.service;

import java.util.Scanner;

import com.jsp.dao.EmployeeDao;
import com.jsp.entity.Address;
import com.jsp.entity.Employee;

public class EmployeeService {
	static Scanner sc = new Scanner(System.in);

	public static void empService() {

		System.out.println("Enter 1 To Add New Employee : ");
		System.out.println("Enter 2 To Fetch The Details Of The Existing Employee : ");
		System.out.println("Enter 3 To Update The Existing Employee Deatils : ");
		System.out.println("Enter 4 To Delete The Existing Employee : ");
		int choice = sc.nextInt();
		System.out.println("---------------------------------------------------------------");
		if (choice == 1) {
			addNewEmployee();
		} else if (choice == 2) {
			getEmpById();
		} else if (choice == 3) {
			updateEmp();
		} else if (choice == 4) {
			deleteEmp();
		}

	}

	public static void addNewEmployee() {
		sc.nextLine();
		System.out.println("Enter The Employee Name : ");
		String empName = sc.nextLine();
		System.out.println("Enter The Employee Phone : ");
		long empPhone = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter The Employee Email : ");
		String empEmail = sc.nextLine();
		System.out.println("--------------------------------------------");
		System.out.println("Enter The Address Details");
		
		System.out.println("--------------------------------------------");
		System.out.println("Enter The Street : ");
		String street = sc.nextLine();
		System.out.println("Enter The city : ");
		String city = sc.nextLine();
		System.out.println("Enter The State : ");
		String state = sc.nextLine();
		System.out.println("Enter The Country : ");
		String country = sc.nextLine();
		System.out.println("Enter The Pincode : ");
		int pincode = sc.nextInt();
		Employee employee = new Employee(empName, empPhone, empEmail);
		Address address = new Address(street, city, state, country, pincode, employee);
		employee.setAddress(address);

		EmployeeDao.addNewEmployee(employee);
	}
	
	public static void getEmpById() {
		System.out.println("Enter The Employee Id Whose Details Needs To Be Fetched : ");
		int id = sc.nextInt();
		
		Employee employee = EmployeeDao.getEmpById(id);
		if (employee != null) {
			System.out.println("Employee Details Are : ");
			System.out.println("Employee Id Is : " + employee.getId());
			System.out.println("Employee Name Is : " + employee.getName());
			System.out.println("Employee Phone Is : " + employee.getPhone());
			System.out.println("Employee Email Is : " + employee.getEmail());
			System.out.println("Employee Date of Joining Is : " + employee.getDateofjoining());

		} else {
			System.out.println("Employee With Id " + id + " Does Not Exist");
		}
	}
	
	public static void updateEmp() {
		System.out.println("Enter Employee Id Whose Details Needs To Be Updated");
		int id = sc.nextInt();
		Employee employee = EmployeeDao.getEmpById(id);
		if (employee != null) {
			sc.nextLine();
			System.out.println("Enter The New Employee Name : ");
			String empName = sc.nextLine();
			System.out.println("Enter The New Employee Phone : ");
			long empPhone = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter The New Employee Email : ");
			String empEmail = sc.nextLine();
			employee.setName(empName);
			employee.setPhone(empPhone);
			employee.setEmail(empEmail);
			EmployeeDao.updateEmp(employee);
		} else {
			System.out.println("Employee With Id " + id + " Does Not Exist");
		}
	}
	
	public static void deleteEmp() {
		System.out.println("Enter Employee Id Whose Details Needs To Be Deleted");
		int id = sc.nextInt();
		Employee employee = EmployeeDao.getEmpById(id);
		if (employee != null) {
			EmployeeDao.deleteDept(employee);
		} else {
			System.out.println("Employee With Id " + id + " Does Not Exist");
		}

	}

}