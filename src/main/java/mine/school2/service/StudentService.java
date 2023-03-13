package mine.school2.service;

import mine.school2.dataobject.Student;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface StudentService {
    void createOne(Student student);

    void remove(Integer id);

    void updateOne(Student student);

    List<Student> findAll(Pageable pageable);

    List<Student> findByNameIn(List<String> nameList);
}
