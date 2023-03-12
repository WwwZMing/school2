package mine.school2.service;

import mine.school2.dataobject.Student;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface StudentService {
    Student createOne(String name, String classGrade, Integer sex);

    void remove(Integer id);

    Student updateOne(Integer id, String name, String classGrade, Integer sex);

    List<Student> findAll(Pageable pageable);

    List<Student> findByNameIn(List<String> nameList);

    Student save(Student s);
}
