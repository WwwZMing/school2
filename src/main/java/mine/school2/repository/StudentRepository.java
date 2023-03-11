package mine.school2.repository;

import mine.school2.dataobject.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameIn(List<String> nameList);
}
