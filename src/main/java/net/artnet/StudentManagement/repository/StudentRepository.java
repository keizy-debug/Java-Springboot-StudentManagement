package net.artnet.StudentManagement.repository;

import net.artnet.StudentManagement.entitty.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long> {
}
