package com.jsp.service;

import java.util.Scanner;

import com.jsp.dao.EmployeeDao;
import com.jsp.entity.Address;
import com.jsp.entity.Employee;

public class AddressService {
    
	private static Scanner sc= new Scanner(System.in);
	public static void addressService(){
		
		System.out.println("Enter 1 To Fetch The Details Of The Existing Address :");
		System.out.println("Enter 2 To Update The Existing Address Details:");
		int choice =sc.nextInt();
		System.out.println("**********************");
		if(choice == 1){
			getAddressById();
		}else if(choice == 2) {
			updateAddress();
		}
	}
	
	
	public static void getAddressById() {
		System.out.println("Enter The Employee Id Whose Address Needs To Be Fetched:");
		int id =sc.nextInt();
		
		Employee employee = EmployeeDao.getEmpById(id);
		if(employee.getAddress()!=null) {
			System.out.println("Employee Address is: ");
			System.out.println("Address Id is: "+ employee.getAddress().getId());
			System.out.println("Street is: "+ employee.getAddress().getStreet());
			System.out.println("City is: "+ employee.getAddress().getCity());
			System.out.println("State is: "+ employee.getAddress().getState()); 
			System.out.println("Country is: "+ employee.getAddress().getCountry());
			System.out.println("Pincode is: "+ employee.getAddress().getPincode());
		}else {
		System.out.println("Employee With Id:" +id+"Does not Exist");
	}
	}
	
	public static void updateAddress() {
		System.out.println("Enter The Employee Id Whose Address Needs To Be Updated:");
		int id=sc.nextInt();
		Employee employee = EmployeeDao.getEmpById(id);
		if(employee!=null) {
			Address address = employee.getAddress();
			sc.nextLine();
			System.out.println("Enter The Street :");
			String street = sc.nextLine();
			System.out.println("Enter The City :");
			String city = sc.nextLine();
			System.out.println("Enter The State :");
			String state = sc.nextLine();
			System.out.println("Enter The Country :");
			String country = sc.nextLine();
			System.out.println("Enter The Pincode :");
			int pincode = sc.nextInt();
			address.setStreet(street);
			address.setCity(city);
			address.setState(state);
			address.setCountry(country);
			address.setPincode(pincode);
			EmployeeDao.updateEmp(employee);
					
		}
		else {
			System.out.println("Employee With Id:" + id +"Does not Exist");
		}
	}
	
	
}