package com.cruddemo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cruddemo.entities.Student;
import com.cruddemo.repository.StudentRepository;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@SpringBootTest
class CrudDemo1ApplicationTests {

	@Autowired
	private StudentRepository studentRepo;
	
	@Test
	void saveOneStudentRecord() {
		Student s1=new Student();
		s1.setName("rajat");
		s1.setCource("testing");
		s1.setFee(1000);
		
		// save object to db
		studentRepo.save(s1);
	}
	@Test
	void deleteOneSturdentRecord() {
		studentRepo.deleteById(7L);
	}

	@Test
	void getOneStudentRecord() {
		
		Optional<Student> findById = studentRepo.findById(5L);
		Student s = findById.get();
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getCource());
		System.out.println(s.getFee());
		
	}
	@Test
	void updateOneStudentRecord() {
		
		Optional<Student> findById = studentRepo.findById(5L);
		Student s = findById.get();
		s.setCource("development");
		studentRepo.save(s);
	}
	@Test
	void getAllStudentRecord() {
		Iterable<Student> findAll = studentRepo.findAll();
		for (Student student : findAll) {
			System.out.println(student.getId());
			System.out.println(student.getCource());
			System.out.println(student.getFee());
			System.out.println(student.getName());
		}
	}
	
}
