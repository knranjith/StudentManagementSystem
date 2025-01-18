package com.studentapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	private static List<Student> studentlist;
	
	public static void main(String[] args)  {

		System.out.println("******** Student Management System ********");
		System.out.println("****** Welcome ******");
		
		studentlist = new ArrayList<Student>();
    
		Student s1 = new Student("Ranjith kumar",29,"S-01");
		Student s2 = new Student("Sneha",28,"S-02");
		Student s3 = new Student("Manasa",27,"S-03");
		Student s4 = new Student("Bindu",29,"S-04");
		
		s1.enrollcorse("Java");
		//s1.enrollcorse("Docker");
		//s1.enrollcorse("Kubernetes");
		//s1.enrollcorse("Java"); //duplicate values are allowed in list interface but with help of method we can avoid it
		s2.enrollcorse("java");
		s2.enrollcorse("Devops");
	    //s3.enrollcorse("Data Science");
	    s3.enrollcorse("DSA");
		s4.enrollcorse("Devops");
		
		//s1.printStudentInfo();
		//s2.printStudentInfo();
		//s3.printStudentInfo();
		
		studentlist.add(s1);
		studentlist.add(s2);
		studentlist.add(s3);
		studentlist.add(s4);
		
		Student result = findStudentById("S-04");
	//	System.out.println("Result : "+result);
		
		sortByName();
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
