package com.studentapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static List<Student> studentlist;
	private static Scanner scc;
	
	public static void main(String[] args)  {

		System.out.println("********* Student Management System *********");
		
		studentlist = new ArrayList<Student>();
		scc = new Scanner(System.in);
		while(true) {
		System.out.println("****** Welcome ******");
		System.out.println("Select an Option......");
        System.out.println("1. Register a Student");
        System.out.println("2. Find Student with StudentID");
        System.out.println("3. List All Student Information");
        System.out.println("4. List Student Info in Sorted Order");
        System.out.println("5. Exit");
         int option = scc.nextInt();
		 
         switch(option) {
         
         case 1:
        	 enrollStudent(scc);
        	 break;
         case 2:
        	 findStudentById(scc);
        	 break;
         case 3:
        	 printAllStudentData();
        	 break;
         case 4:
        	 sortByName(); 
        	 break;  
         case 5:
        	 exit();
        	 break;
         default: System.out.println("Invalid option selected!....Enter between 1 to 5");
        	 
         }
		}
	 
	}
	
	private static void exit() {
		System.out.println("Closing the Window");
		System.exit(0);
	}

	private static void printAllStudentData() {
		if(studentlist.size()>0) {
		System.out.println("-------------printing allStudent Info-----------");
		for (Student student : studentlist) {
			  student.printStudentInfo();
		}
	     System.out.println("---------*********-------------");	
		}
		else {
			System.err.println("Student list is empty : No student data found");
		}
	}

	private static void findStudentById(Scanner scc2) {
		Student studentFound = null;
		System.out.println("Enter the studentId");
		String studentId = scc2.next();
		try {
			studentFound = studentlist.stream().filter(x->x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
		.orElseThrow(()-> new RuntimeException("No Data Found!!!"));
		}
		catch(RuntimeException e) {
			System.err.println("Student with ID : "+studentId+" is Not Found!!!");
		}
		studentFound.printStudentInfo();
	}

	private static void enrollStudent(Scanner scc2) {
		System.out.println("Enter the Student Name");
		String studentName = scc2.next();
		
		System.out.println("Enter the Student Age");
		int studentAge = scc2.nextInt();
		
		System.out.println("Enter the Student Id");
		String studentId = scc2.next();
		
		Student newStudent = new Student(studentName,studentAge,studentId);
		studentlist.add(newStudent);
		//System.out.println("Student Added successfully into the Data Base");
		while (true) {
			System.out.println("Enter the student course to be enrolled : type done to exit");
			String studentCourse = scc2.next();
			if (studentCourse.equalsIgnoreCase("done")) {
				break; // used to exit from the LOOP
			}
			newStudent.enrollcorse(studentCourse);
		}
		 newStudent.printStudentInfo();
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
		printAllStudentData();
		
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
