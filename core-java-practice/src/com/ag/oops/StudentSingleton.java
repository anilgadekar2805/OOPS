package com.ag.oops;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Student implements Cloneable, Serializable {
	
	private Student() {
		
		if(student !=null){
			throw new IllegalStateException("Using reflection API does not allow to create object of Student class ");
		} 
	}
	
	private static Student student = null;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		//return super.clone();
		return new CloneNotSupportedException(" Not allow create object using clone method");
	}
	// Override the Deserialization method for preventing new instance creation
	public Object readResolve() {
		return student;
	}
	
	public static synchronized Student getStudentInstance() {
		if(student == null){
			return student  = new Student();
		}else{
			return student;
		}
	}// static method
	
}//class


public class StudentSingleton {

	public static void main(String[] args) throws CloneNotSupportedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		Student std1 = Student.getStudentInstance();
		Student std2 = Student.getStudentInstance();
		System.out.println("Using Instance method : std1 = "+std1.hashCode());
		System.out.println("Using Instance method : std2 = "+std2.hashCode());
		System.out.println("std1==std2 : "+(std2.hashCode() == std1.hashCode()));
		
		/**
		 *  preventing Student class new object instantiation using 'clone() method'
		 * */
		// try to create new object of student class using clone
		
		Student studentClone = (Student) std1.clone();
		System.out.println("Using clone method : studentClone = "+studentClone.hashCode());
		System.out.println(" std1==studentClone :  "+(std2.hashCode() == studentClone.hashCode()));
		// preventing to creating of object using clone method
		// Throw Exception in clone method which has return type is CloneNotSupportedException object
		
		/**
		 *  preventing Student class new object instantiation using ' Reflection API '
		 * */
		// try to create new object of student class using Reflection API
		// First take all constructors present into student class 
		// make them accessible to outside to create object
		
		Student studentReflactionapi = null;
		Constructor<Student>[] constructors = (Constructor<Student>[]) Student.class.getDeclaredConstructors();
		for(Constructor constructor : constructors) {
			 constructor.setAccessible(true);
			 studentReflactionapi = (Student) constructor.newInstance();
		}
		System.out.println("Using Reflaction API : studentReflectionapi = "+studentReflactionapi.hashCode());
		System.out.println(" std1==studentReflactionapi :  "+(std1.hashCode() == studentReflactionapi.hashCode() ));
		
		// preventing object creation using above way
		// First take all constructors present into student class
		// Inside student class private constructor check given method created only one object or NOT
		// if it is created throws Exception like : IllegalStateException("Using Reflection API not allow to create object of Student class ") 
		
		/**
		 *  preventing Student class new object instantiation using ' Serialization and Deserialization '
		 * */
		// first try to create new object of student class using Serialization
		//  OutputStreamWriter class contain  
		try{
        // Saving of object in a file 
        FileOutputStream OSfile = new FileOutputStream("file_student.txt"); 
        ObjectOutputStream out = new ObjectOutputStream(OSfile); 
        // Method for serialization of object 
        out.writeObject(std1); 
        out.close(); 
        OSfile.close();
        
        // Reading the object from a file 
        FileInputStream ISfile = new FileInputStream("file_student.txt"); 
        ObjectInputStream in = new ObjectInputStream(ISfile); 
        // Method for deserialization of object 
        Student studDeserialize = (Student)in.readObject(); 
       
        System.out.println("Serealization and Desearilization : studDeserialize = "+studDeserialize.hashCode());
		System.out.println(" std1==studentReflactionapi :  "+(std1.hashCode() == studDeserialize.hashCode() ));
        
        in.close(); 
        ISfile.close(); 
       
		}catch(Exception e){
			e.printStackTrace();
		}
		// Prevent from S/D instance creation using overriding readResolve() method into Student class
		// readResolve method invoke when object Deserialize process 
		// At that time we provide return type as a single instance to the  method
	}

}
