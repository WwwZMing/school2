package mine.school2.service;

import mine.school2.dataobject.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface StudentService {
    void createOne(Student student);

    void remove(Integer id);

    void updateOne(Student student);

    Page<Student> findAll(Pageable pageable);

    List<Student> findByNameIn(List<String> nameList);
}
