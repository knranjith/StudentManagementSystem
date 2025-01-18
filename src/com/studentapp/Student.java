package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Student {

private	String name;                         // String is a class therefore starts with upper case
private	int age;
private	String studentId;
private	List<String> courses;                //we have created variables inside the class i.e instance variables (always marked with private keyword)
                                         //non primitive datatype(String,List<>String) will always have default value as 'null'     And primitive datatype(int,byte,long,float) will have respective default values
public Student(String name, int age, String studentId) {
	super();
	if(ValidateAge(age)&&ValidateName(name)&&ValidateStudentId(studentId)) {
	  this.name = name;
	  this.age = age;
	  this.studentId = studentId;
	  courses= new ArrayList<String>(); //initialization of courses
	}
}



public void enrollcorse(String course)
{  if(ValidateCourseName(course)) {
	
	if(!courses.contains(course)) {
	    courses.add(course);
	   System.out.println("student enrolled to "+course+" : successfully ");
	}
	else {
		System.err.println("student already enrolled to this course : "+course);
	  }
	
   }
}

public void printStudentInfo() {
	
	System.out.println("student name : "+name);
	System.out.println("student age : "+ age);
	System.out.println("student Id : "+studentId);
	System.out.println("Enrolled for : "+courses);
	System.out.println("=======================================");
	
	
}

@Override
public String toString() {
	return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
}

public boolean ValidateAge(int age) {
	
	if(age>=19 && age <=35) {
		
		return true;
	}
	
	else {
		System.err.println("Invalid Age, Student age should be between 19 and 35!!!!!");
		return false;
	}
	
}

public boolean ValidateName(String name) {
	
	String nameRegex ="^[a-zA-Z\\s]+$";
	Pattern namePattern = Pattern.compile(nameRegex);
	  Matcher nameMatcher = namePattern.matcher(name);
	 if(nameMatcher.matches()) {
		 return true;
	 }
	
	 else {
		 System.err.println("invalid name :name should be in alphabet format ");
		 return false;
	 }
} 



public boolean ValidateStudentId(String studentId) {
	
	String idRegex ="S-\\d+$";  
	    Pattern idPattern = Pattern.compile(idRegex);
	   Matcher idMatcher = idPattern.matcher(studentId);
	   if(idMatcher.matches())
	   {
		   return true;
	   }
	
	   else {
		   System.err.println("Invalid studentID format: ID should start with S-123...");
		   return false;
	   }
	
}

public boolean ValidateCourseName(String course) {
	if(course.equalsIgnoreCase("Java")||course.equalsIgnoreCase("DSA")||course.equalsIgnoreCase("Devops")){
		
		return true;
	}
	else {
		System.err.println("Invalid course name  please select the course from the list:[java,DSA,Devops] ");
		return false;
	}
	
	
}

public String getName() {
	return name;
}

public int getAge() {
	return age;
}

public String getStudentId() {
	return studentId;
}

public List<String> getCourses() {
	return courses;
}









}
