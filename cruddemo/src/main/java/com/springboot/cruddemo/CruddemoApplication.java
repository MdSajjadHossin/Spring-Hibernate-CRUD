package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner ->{
			//createStudent(studentDAO);
//			CreateMultipleStudebts(studentDAO);

//			readStudent(studentDAO);

//			QueryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

			deleteAllStudent(studentDAO);
		};

	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleting all student");
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 7;
		System.out.println("Deleteing student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 7;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to " shawchat to pagla"
		System.out.println("Updating student....");
		myStudent.setFirstName("Pagla");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated Student: "+myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Farib");

		// display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void QueryForStudents(StudentDAO studentDAO) {

		// get a list of student
		List<Student> theStudents = studentDAO.findAll();

		// display the list of student
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Shawkhot", "Farib", "farib@gmail.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Save student. Generated id: "+ theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);


	}

	private void CreateMultipleStudebts(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("Md Sajid", "Hossin", "sajjad01.springboot.com");
		Student tempStudent2 = new Student("Md Fahim", "Ahmed", "fahim@bhate.com");
		Student tempStudent3 = new Student("Abdul", "Kalam", "kalam@abdul.com");

		// save the student object
		System.out.println("Saving the student object...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Md Sajjad", "Hossin", "sajjadcse207@gmail.com");

		// save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student Generated id: " + tempStudent.getId());
	}


}
