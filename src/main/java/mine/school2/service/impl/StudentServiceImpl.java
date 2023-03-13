package mine.school2.service.impl;

import mine.school2.dataobject.Student;
import mine.school2.repository.StudentRepository;
import mine.school2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //新增
    @Override
    public void createOne(Student student) {
        String number = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis());
        student.setNumber(number);
        studentRepository.save(student);
    }

    @Override
    public void remove(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void updateOne(Student student) {
        Student s = studentRepository.findById(student.getId()).orElse(null);
        Assert.notNull(s, "object is null");
        s.setName(Optional.ofNullable(student.getName()).orElse(s.getName()));
        s.setSex(Optional.ofNullable(student.getSex()).orElse(s.getSex()));
        s.setStatus(Optional.ofNullable(student.getStatus()).orElse(s.getStatus()));
        s.setDescription(Optional.ofNullable(student.getDescription()).orElse(s.getDescription()));
        s.setClassGrade(Optional.ofNullable(student.getClassGrade()).orElse(s.getClassGrade()));
        studentRepository.save(s);
    }

    @Override
    public List<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Student> findByNameIn(List<String> nameList) {
        return studentRepository.findByNameIn(nameList);
    }
}
