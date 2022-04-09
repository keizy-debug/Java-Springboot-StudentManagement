package net.artnet.StudentManagement.service.impl;

import net.artnet.StudentManagement.entitty.Student;

import net.artnet.StudentManagement.exception.ResourceNotFoundException;
import net.artnet.StudentManagement.repository.StudentRepository;
import net.artnet.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        super();
        this.studentRepository =studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
//        Optional<Student> student = studentRepository.findById(id);
//        if(student.isPresent()){
//            return student.get();
//        }
//        else{
//            throw new ResourceNotFoundException("Student","Id","id");
//        }
        //or lambda below
        return studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","Id","id"));
    }

    @Override
    public Student updateStudent(Student student, long id) {
        // first we need to check the student with given id existing in DB or not

        Student existingStudent = studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("student", "ID", "id"));

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        //save existing student to DB

        studentRepository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteStudent(long id) {
        //check whether Student exist in DB or not
        studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","Id","id"));
        studentRepository.deleteById(id);
    }


 }
