package net.artnet.StudentManagement.controller;


import net.artnet.StudentManagement.entitty.Student;
import net.artnet.StudentManagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService){
        super();
        this.studentService = studentService;
    }

//    //http://localhost:8080/student
//    @GetMapping("/student")
//    public Student getStudent(){
//        return new Student("kudz", "kutya", "kutya@artnet.net");
//    }
//
//    @GetMapping("/students")
//    public List<Student> getStudents(){
//       List<Student> students = new ArrayList<>();
//       students.add(new Student("kudz", "kutya", "kutya@artnet.net"));
//        students.add(new Student("arthur", "kutyaz", "kutyaz@artnet.net"));
//        students.add(new Student("keizy", "kuty", "kuty@artnet.net"));
//        students.add(new Student("kudzkeizy", "kutyauripo", "kutyauripo@artnet.net"));
//        return students;
//    }
//
//    //PathVariable annotation
//    //http://localhost:8080/student/kudz
//    //@PathVariable is used to bind url template variable with method parameter
//
//    @GetMapping("/student/{fistName}/{lastName}")
//    public Student studentPathVariable(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
//        return new Student(firstName, lastName);
//    }
//
//    //build restAPi to handle query parameters
//    //  //http://localhost:8080/student?firstname=kudz&lastName=kuty
//    @GetMapping("/student/query")
//    public Student StudentQueryParam(@RequestParam(name = "firstName") String firstName,
//                                     @RequestParam(name = "lastName") String lastName){
//        return new Student(firstName, lastName);
//    }

    //build create employee REST API
    //@Requestbody allows us to retrieve the requesti's body(json) and automatically convert it to java object
    @PostMapping()
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
    }

    //build get all employees REST API
    @GetMapping()
    public List<Student> getALlStudents(){
        return studentService.getAllStudents();
    }

    //build get Student by id in REST API
    //http://localhost:8080/api/students/1

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId){
        return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    //build update student REST API
    //http://localhost:8080/api/students/1
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    //build delete Employee REST API
    //http://localhost:8080/api/students/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){

        //delete student from DB
        studentService.deleteStudent(id);

        return new ResponseEntity<String>("Student deleted Successfully",HttpStatus.OK);
    }

}