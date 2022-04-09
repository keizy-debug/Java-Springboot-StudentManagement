package net.artnet.StudentManagement;

import net.artnet.StudentManagement.entitty.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class StudentManagementApplication  {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}



//	@Autowired
//	private StudentRepository studentRepository;
//
//	implements CommandLineRunner
//	@Override
//	public void run(String... args) throws Exception {
//		Student student1= new Student("keizy", "Kutya", "kutya@artnet.net");
//		studentRepository.save(student1);
//
//		Student student2 = new Student("arthur","kutya", "art@artnet.com");
//
//		studentRepository.save(student2);
//	}
}
