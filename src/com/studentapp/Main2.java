package com.studentapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	private static List<Student> studentlist;
	
	public static void main(String[] args)  {

		System.out.println("******** Student Management System ********");
		System.out.println("****** Welcome ******");
	 studentlist = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Name!!!!!!");
		String name = sc.next();
		System.out.println("Entered name : "+name);
		
		System.out.println("please Enter the Age!!");
		int age = sc.nextInt();
		System.out.println("Entered Age : " + age);
		
	}
	
	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1,o2) ->o1.getName().compareTo(o2.getName());
				
			/*  	new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				  return o1.getName().compareTo(o2.getName());
			}
		};        */
		
		Collections.sort(studentlist,studentNameComparator);
		System.out.println(studentlist);
		
	}

	public static Student findStudentById(String studentid) {
		Student result = null;
		try {
		 result = studentlist.stream().filter(x->x.getStudentId().equalsIgnoreCase(studentid)).findFirst()
		.orElseThrow(()-> new RuntimeException("No Data Found!!!"));
		}
		catch(RuntimeException e) {
			System.err.println("Student with ID : "+studentid+" is Not Found!!!");
		}
		return result;
	}
	
	

}
