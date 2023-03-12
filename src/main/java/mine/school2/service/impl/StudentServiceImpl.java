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

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //新增
    @Override
    public Student createOne(String name, String classGrade, Integer sex) {
        String number = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis());
        Student s = new Student(name, sex, classGrade);
        s.setNumber(number);
        return s;
    }

    @Override
    public void remove(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateOne(Integer id, String name, String classGrade, Integer sex) {
        Student s = studentRepository.findById(id).orElse(null);
        Assert.notNull(s,"object is null");
        s.setSex(sex);
        s.setName(name);
        s.setClassGrade(classGrade);
        return s;
    }

    @Override
    public List<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Student> findByNameIn(List<String> nameList) {
        return studentRepository.findByNameIn(nameList);
    }

    @Override
    public Student save(Student s) {
        return studentRepository.save(s);
    }
}
